package backtrack.combinations;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class CombinationsTest {

    private Combinations solution = new Combinations();

    @Test
    public void combine() {
        List<List<Integer>> ans = solution.combine(4, 2);
        System.out.println(ans);
    }

    @Test
    public void combine_1() {
        List<List<Integer>> ans = solution.combine(1, 1);
        System.out.println(ans);
    }

}