package linkedlist.lruCache;

/* *****************************************************************************

146. LRU 缓存机制
运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。

实现 LRUCache 类：
LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4

提示：
1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
最多调用 3 * 104 次 get 和 put

*******************************************************************************/

/* *****************************************************************************

题解：
使用 哈希表 + 双向链表来实现

复杂度分析：
时间复杂度：O(1)
空间复杂度：O(capacity)

*******************************************************************************/

import java.util.HashMap;
import java.util.Map;

/**
 * @author davewang
 */
public class LRUCache {

    /**
     * capacity
     */
    private int capacity;
    /**
     * size
     */
    private int size;
    /**
     * case
     */
    private Map<Integer, LinkedNode> cache = new HashMap<>();
    /**
     * 头结点和尾结点
     */
    private LinkedNode head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 哨兵 头结点和尾结点，方便操作
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
     */
    public int get(int key) {
        LinkedNode linkedNode = cache.get(key);
        if (linkedNode == null) {
            return -1;
        }

        // 移动到头结点
        move2head(linkedNode);

        return linkedNode.value;
    }

    /**
     * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    public void put(int key, int value) {
        LinkedNode linkedNode = cache.get(key);
        // 如果关键字已经存在，则变更其数据值
        if (linkedNode != null) {
            linkedNode.value = value;
            // 只要更新了都要移动到头结点
            move2head(linkedNode);
        }
        // 如果关键字不存在，则插入该组「关键字-值」
        else {
            // 先插入到头结点
            LinkedNode newNode = new LinkedNode(key, value);
            add2head(newNode);
            cache.put(key, newNode);
            size++;

            // 已经满了，删除尾结点
            if (size > capacity) {
                LinkedNode node = removeTail();
                cache.remove(node.key);
            }
        }
    }

    private void add2head(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private LinkedNode removeTail() {
        LinkedNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    private void move2head(LinkedNode linkedNode) {
        removeNode(linkedNode);
        add2head(linkedNode);
    }

    /**
     * linked
     */
    class LinkedNode {

        private int key;
        private int value;
        private LinkedNode prev;
        private LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
