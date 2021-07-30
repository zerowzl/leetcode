package array.intersectionOfTwoArrays2;

/* *****************************************************************************

350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。 
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9] 

说明：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 我们可以不考虑输出结果的顺序。 

进阶：
 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 

*******************************************************************************/


/* *****************************************************************************

题解：
hash

复杂度分析：
时间复杂度：O(n)
空间复杂度：O(n)

1. 如果给定的数组已经排好序呢？你将如何优化你的算法？
双指针
2. 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
nums1 hash
3. 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
对 nums2 的数据进行 hash 分片存多个文件, nums1 hash --> 对应文件

*******************************************************************************/

import java.util.*;

/**
 * @author Dave Wang
 */
public class IntersectionOfTwoArrays2 {

    public int[] intersectHash(int[] nums1, int[] nums2) {
        // key --> arr element, value --> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                if (count > 0) {
                    list.add(num);
                    map.put(num, count - 1);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
