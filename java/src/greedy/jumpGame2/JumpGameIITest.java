package greedy.jumpGame2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class JumpGameIITest {

    private JumpGameII solution = new JumpGameII();


    @Test
    public void jump() {
        assertEquals(2, solution.jump(new int[]{2, 3, 0, 1, 4}));
        assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(2, solution.jump(new int[]{2, 0, 4, 1, 4}));
        assertEquals(2, solution.jump(new int[]{2, 0, 2, 1, 4}));
        assertEquals(4, solution.jump(new int[]{1, 1, 1, 1, 4}));
        assertEquals(1, solution.jump(new int[]{4, 1, 1, 1, 4}));
        assertEquals(1, solution.jump(new int[]{0}));
    }
}