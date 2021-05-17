package array.containerWithMostWater;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class ContainerWithMostWaterTest {


    @Test
    public void test() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, solution.maxArea(new int[]{1, 1}));
        assertEquals(16, solution.maxArea(new int[]{4, 3, 2, 1, 4}));
    }

}