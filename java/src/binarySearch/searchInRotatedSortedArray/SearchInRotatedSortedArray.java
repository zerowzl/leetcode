package binarySearch.searchInRotatedSortedArray;

/* *****************************************************************************

33. 搜索旋转排序数组
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1

提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4

进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
Related Topics 数组 二分查找

*******************************************************************************/

/* *****************************************************************************

题解1：
先找分界点，判断目标值在那个区间，而后对改区间进行二分查找

复杂度分析：
时间复杂度：找分界点这一步是 O(n)的，二分查找是 O(log n)的，因此是 O(n)的
空间复杂度：O(1)

题解2：
先找分界点，得到最小的值的下标，而后进行二分查找，但取值元素的下标使用先加上先前得到的分界点下标并进行取模（数组长度），
这样就可以对数组元素进行有序的比较了

复杂度分析：
时间复杂度：找分界点这一步是 O(n)的，二分查找是 O(log n)的，因此是 O(n)的
空间复杂度：O(1)

题解3：
直接使用二分查找，当把数组根据 mid 分成两部分之后，我们可以确认的是，有一部分肯定是有序的，
所以关键就是如何找到那部分是有序的，然后判断 target 是否在该有序数组范围内。
我们可以通过判断 nums[0] 和 nums[mid] 的大小来确定哪一部分是有序的，
如果 nums[0] <= nums[mid]，则说明左边是有序的，否则有序的就是右边，
然后判断临界区的值和 target 的大小关系来确定查找的区间。

复杂度分析：
时间复杂度：O(log n)
空间复杂度：O(1)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }


        // 先找到分界点
        int low = 0;
        int high = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                // 找到分界点了
                if (target >= nums[0]) {
                    low = 0;
                    high = i;
                } else {
                    low = i + 1;
                    high = nums.length - 1;
                }
                break;
            }
        }

        // 二分查找
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int searchWithMod(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }


        // 先找到分界点，注意是最小的值
        int mod = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                mod = i + 1;
                break;
            }
        }

        // 二分查找
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // 中点下标
            int mid = low + ((high - low) >> 1);
            // 真实的取值下标
            int index = (mid + mod) % nums.length;
            if (nums[index] > target) {
                high = mid - 1;
            } else if (nums[index] < target) {
                low = mid + 1;
            } else {
                return index;
            }
        }

        return -1;
    }

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) { // 左边是有序的
                // target 在左边范围内
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    // 在右边范围内
                    low = mid + 1;
                }
            } else {
                //  右边是有序的
                // target 在右边范围内
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    // 在左边范围内
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public int searchBS(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else {
                // 左边有序
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && nums[mid] >= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[nums.length - 1] >= target && nums[mid] <= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}

