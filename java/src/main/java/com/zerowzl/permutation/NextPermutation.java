package com.zerowzl.permutation;

/**
 * 下一个排列.
 *
 * @author davewang
 */
public class NextPermutation {

    /**
     * 从右向左进行比较并交换。
     * 1）右边的元素大于左边的元素，交换并返回，就是下一个排列，不需要看左边更高位的元素。
     * 比如：[1,2,3] ==> [1,3,2]，[2,1,3] ==> [2,3,1]
     * 2）如果右边的元素小于左边的元素，则需要比较更高位（左-1，设为a）元素的大小。这时有三种情况：
     * 2-1）a 比左和右都小，则将右移动到 a 的位置，a 和剩余的元素向后顺移。[1,3,2] ==> [2,1,3]
     * 2-2）a 介于左和右之间，则将 a 移动到右的位置，剩余的元素向左顺移。[2,3,1] ==> [3,1,2]
     * 2-3）a 比左和右都大，则交换右和 a 的位置，[3,2,1]；
     * 然后继续查看左-1元素和当前数列的大小关系，如果还是最大值，则移动到数组最后，其他元素向前移动；[4,3,2,1]；
     * 继续查看左-1的元素直到不满足为止。如果比最大值要小，则依次和右边的元素值进行比较，交换以第一个小的元素。
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        int n = nums.length;
        int rightIndex = n - 1;
        int right = nums[rightIndex];
        int leftIndex = n - 2;
        int left = nums[leftIndex];
        // 右边的元素大于左边的元素，交换
        if (right > left) {
            swap(nums, rightIndex, leftIndex);
        } else {
            // 右边的元素小于左边的元素，则需要比较更高位（左-1，设为a）元素的大小
            int aIndex = leftIndex - 1;
            int a = nums[aIndex];
            if (a < right) {
                // a 比左和右都小，则将右移动到 a 的位置，a 和剩余的元素向后顺移
                swap(nums, leftIndex, rightIndex);
                swap(nums, aIndex, leftIndex);
            } else if (a < left) {
                // a 介于左和右之间
                swap(nums, aIndex, leftIndex);
                swap(nums, leftIndex, rightIndex);
            } else {
                // a 比左和右都大
                int max = a;
                swap(nums, aIndex, rightIndex);
                for (int i = aIndex - 1; i >= 0; i--) {
                    if (nums[i] >= max) {
                        max = nums[i];
                        // 依次交换元素
                        int j = i;
                        int c = rightIndex - i;
                        while (c > 0) {
                            swap(nums, j, j + 1);
                            j++;
                            c--;
                        }
                    }  else {
                        for (int j = i; j < n; j++) {
                            if (nums[i] < nums[j]) {
                                swap(nums, i, j);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
