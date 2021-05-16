package queue.designCircularQueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class MyCircularQueueTest {


    @Test
    public void test() {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        assertTrue(circularQueue.enQueue(1));  // 返回 true
        assertTrue(circularQueue.enQueue(2));  // 返回 true
        assertTrue(circularQueue.enQueue(3));  // 返回 true
        assertFalse(circularQueue.enQueue(4));  // 返回 false，队列已满
        assertEquals(3, circularQueue.Rear());  // 返回 3
        assertTrue(circularQueue.isFull());  // 返回 true
        assertTrue(circularQueue.deQueue());  // 返回 true
        assertTrue(circularQueue.enQueue(4));  // 返回 true
        assertEquals(4, circularQueue.Rear());  // 返回 4
    }

}