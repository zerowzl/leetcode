package array.intersectionOfTwoArrays2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class IntersectionOfTwoArrays2Test {

    private IntersectionOfTwoArrays2 solution = new IntersectionOfTwoArrays2();

    @Test
    public void intersectHash() {
        assertArrayEquals(new int[]{2, 2}, solution.intersectHash(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{9, 4}, solution.intersectHash(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}