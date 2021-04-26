package recursion.swapPairs;

import com.sun.corba.se.impl.protocol.InfoOnlyServantCacheLocalCRDImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dave Wang
 */
public class SwapPairsTest {

    @Test
    public void test() {
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = swapPairs.swapPairs(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))));
        int index = 0;

        while (listNode != null) {
            int val = listNode.val;
            if (index == 0) {
                Assert.assertEquals(2, val);
            } else if (index == 1) {
                Assert.assertEquals(1, val);
            } else if (index == 2) {
                Assert.assertEquals(4, val);
            } else if (index == 3) {
                Assert.assertEquals(3, val);
            } else if (index == 4) {
                Assert.assertEquals(5, val);
            }
            listNode = listNode.next;
            index++;
        }
    }


}
