package dp.jumpGameII;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void jump() {
        assertEquals(2, solution.jump(new int[]{2, 3, 1, 14}));
    }
}