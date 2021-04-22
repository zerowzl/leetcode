package stack.implementQueueUsingStacks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class MyQueueTest {

    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);  // queue is: [1]
        myQueue.push(2);  // queue is: [1, 2] (leftmost is front of the queue)
        int peek = myQueue.peek(); // return 1
        Assert.assertEquals(peek, 1);
        int pop = myQueue.pop(); // return 1, queue is [2]
        Assert.assertEquals(pop, 1);
        boolean empty = myQueue.empty(); // return false
        Assert.assertFalse(empty);
    }

}
