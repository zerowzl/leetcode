package greedy.jumpGame;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class JumpGameTest {

    private JumpGame solution = new JumpGame();

    @Test
    public void canJump() {
        assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }


}