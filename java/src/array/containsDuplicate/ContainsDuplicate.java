package array.containsDuplicate;

/* *****************************************************************************

217. 存在重复元素

*******************************************************************************/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dave Wang
 */
public class ContainsDuplicate {

    // 1. map/Set
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    // sort
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
