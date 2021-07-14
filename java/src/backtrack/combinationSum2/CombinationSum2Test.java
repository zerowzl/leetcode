package backtrack.combinationSum2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class CombinationSum2Test {

    CombinationSum2 solution = new CombinationSum2();

    @Test
    public void combinationSum2() {
        List<List<Integer>> res = solution.combinationSum2(new int[]{2, 2, 1, 2}, 5);
        System.out.println(res);
    }

    @Test
    public void combinationSum2_1() {
        List<List<Integer>> res = solution.combinationSum2(new int[]{5, 2, 2, 1, 2}, 5);
        System.out.println(res);
    }
}