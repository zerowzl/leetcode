package heap.findKthLargest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class FindKthLargestTest {

    @Test
    public void findKthLargest() {
        FindKthLargest solution = new FindKthLargest();
        assertEquals(5, solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}