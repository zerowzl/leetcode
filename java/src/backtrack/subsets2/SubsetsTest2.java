package backtrack.subsets2;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class SubsetsTest2 {

    private Subsets2 solution = new Subsets2();

    @Test
    public void subsets() {
        List<List<Integer>> ans = solution.subsetsWithDup(new int[]{});
        System.out.println(ans);
    }

    @Test
    public void subsets1() {
        List<List<Integer>> ans = solution.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(ans);
    }


}