package bits.hammingDistance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class HammingDistanceTest {

    private HammingDistance solution = new HammingDistance();

    @Test
    public void hammingDistance() {
        assertEquals(1, solution.hammingDistance(1, 3));
        assertEquals(2, solution.hammingDistance(1, 4));
        assertEquals(31, solution.hammingDistance(1, -1));
    }
}