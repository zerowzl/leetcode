package linkedlist.lruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 */
class LRUCache {

    private int capacity;

    private Map<Integer, Node> map;

    private ListNode cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new ListNode();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            cache.remove(node);
            map.remove(key);
            Node newNode = new Node(node.key, node.value);
            cache.addHead(newNode);
            map.put(key, newNode);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            map.remove(key);
            cache.remove(node);
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            cache.addHead(newNode);
        } else {
            // 满了
            if (capacity == cache.size) {
                Node removeTail = cache.removeTail();
                map.remove(removeTail.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            cache.addHead(newNode);
        }
    }

    static class ListNode {
        // 虚拟头结点和尾结点，方便操作
        private Node head;
        private Node tail;
        // 大小
        int size;

        // 初始化
        public ListNode() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 添加到头部
        public void addHead(Node node) {
            Node oldNext = head.next;
            head.next = node;
            node.next = oldNext;
            oldNext.prev = node;
            node.prev = head;
            size++;
        }

        // 从尾部移除
        public Node removeTail() {
            return remove(tail.prev);
        }

        // 移除当前结点
        public Node remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
            return node;
        }

        public int size() {
            return size;
        }

    }

    // 结点
    static class Node {
        private int key;
        private int value;

        // 前驱和后继结点
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
