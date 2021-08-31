"""
35.搜索插入位置

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。

示例 1:
输入: nums = [1,3,5,6], target = 5
输出: 2

示例 2:
    输入: nums = [1,3,5,6], target = 2
    输出: 1

示例 3:
    输入: nums = [1,3,5,6], target = 7
    输出: 4

示例 4:
    输入: nums = [1,3,5,6], target = 0
    输出: 0

示例 5:
    输入: nums = [1], target = 0
    输出: 0

提示:
    1 <= nums.length <= 10⁴
    -10⁴ <= nums[i] <= 10⁴
    nums 为无重复元素的升序排列数组
    -10⁴ <= target <= 10⁴

"""

import unittest
from typing import List


class Solution:

    def searchInsert(self, nums: List[int], target: int) -> int:
        """
        二分查找，O(log n)
        """
        n = len(nums)
        low = 0
        high = n - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                # 到最后了
                if mid == n - 1:
                    return mid + 1
                else:
                    # 看看右边一个, 如果大于等于 target，那就是答案。
                    if nums[mid + 1] >= target:
                        return mid + 1
                    else:
                        low = mid + 1
            else:
                # 第一个了
                if mid == 0:
                    return 0
                else:
                    high = mid - 1


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_plusOne(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 5)
        self.assertEqual(2, ans)

    def test_plusOne_1(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 2)
        self.assertEqual(1, ans)

    def test_plusOne_2(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 7)
        self.assertEqual(4, ans)

    def test_plusOne_3(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 0)
        self.assertEqual(0, ans)

    def test_plusOne_4(self):
        ans = self.solution.searchInsert([1], 0)
        self.assertEqual(0, ans)


if __name__ == '__main__':
    unittest.main()
