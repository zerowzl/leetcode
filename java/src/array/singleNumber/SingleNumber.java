package array.singleNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* *****************************************************************************
136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]
输出: 1

示例 2:
输入: [4,1,2,1,2]
输出: 4

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class SingleNumber {
    
    public int singleNumber(int[] nums) {
        // list
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int i = list.indexOf(num);
            if (i != -1) {
                list.remove(i);
            } else {
                list.add(num);
            }
        }
        return list.get(0);
    }

    public int singleNumberV2(int[] nums) {
        // sort
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public int singleNumberV3(int[] nums) {
        // 任何数和0异或都是自己
        // 任何数自己和自己异或都是0
        int i = 0;
        for (int num : nums) {
            i = i ^ num;
        }
        return i;
    }
}
