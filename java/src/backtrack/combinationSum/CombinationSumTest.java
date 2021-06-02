package backtrack.combinationSum;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class CombinationSumTest {

    private CombinationSum solution = new CombinationSum();

    @Test
    public void combinationSum() {
        // candidates = [2,3,6,7], target = 7
        List<List<Integer>> res = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    @Test
    public void combinationSum2() {
        // candidates = [2,3,5], target = 8,
        List<List<Integer>> res = solution.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

}