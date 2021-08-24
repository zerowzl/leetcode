package backtrack.permute;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class PermuteTest {

    private Permute solution = new Permute();

    @Test
    public void permute() {
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    @Test
    public void permuteV2() {
        System.out.println(solution.permuteV2(new int[]{1, 2, 3}));
    }
}