package linkedlist.lruCache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author davewang
 */
public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        assertEquals(1, lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        assertEquals(-1, lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        assertEquals(-1, lRUCache.get(1));    // 返回 -1 (未找到)
        assertEquals(3, lRUCache.get(3));    // 返回 3
        assertEquals(4, lRUCache.get(4));    // 返回 4
    }

    @Test
    public void test2() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {2=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=1}
        lRUCache.put(2, 3); // 缓存是 {2=3, 1=1}
        lRUCache.put(4, 1); // 缓存是 {4=1, 2=3}
        assertEquals(-1, lRUCache.get(1));
        assertEquals(3, lRUCache.get(2));
    }



}