package heap.topKFrequent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class TopKFrequentTest {

    @Test
    public void topKFrequent() {
        TopKFrequent solution = new TopKFrequent();
        assertArrayEquals(new int[]{2, 1}, solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, solution.topKFrequent(new int[]{1}, 1));
        assertArrayEquals(new int[]{-1, 2}, solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}