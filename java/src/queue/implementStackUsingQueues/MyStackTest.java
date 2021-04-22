package queue.implementStackUsingQueues;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class MyStackTest {

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();// 返回 2
        Assert.assertEquals(2, top);
        int pop = myStack.pop();// 返回 2
        Assert.assertEquals(2, pop);
        boolean empty = myStack.empty();// 返回 False
        Assert.assertFalse(empty);
    }

}
