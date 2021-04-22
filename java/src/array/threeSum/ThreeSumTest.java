package array.threeSum;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class ThreeSumTest {

    @Test
    public void test() {
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }

}
