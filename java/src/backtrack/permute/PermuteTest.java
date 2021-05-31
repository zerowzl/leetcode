package backtrack.permute;

import org.junit.Test;

/**
 * @author Dave Wang
 */
public class PermuteTest {

    @Test
    public void permute() {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }
}