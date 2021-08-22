package dbsf.allPathsFromSourceToTarget;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void allPathsSourceTarget() {
        List<List<Integer>> res = solution.allPathsSourceTarget(
                new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{3}, new int[]{}});
        System.out.println(res);
    }
}