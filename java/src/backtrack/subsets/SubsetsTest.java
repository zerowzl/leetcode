package backtrack.subsets;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class SubsetsTest {

    private Subsets solution = new Subsets();

    @Test
    public void subsets() {
        List<List<Integer>> ans = solution.subsets(new int[]{});
        System.out.println(ans);
    }

    @Test
    public void subsets1() {
        List<List<Integer>> ans = solution.subsets(new int[]{1, 2, 3});
        System.out.println(ans);
    }


}