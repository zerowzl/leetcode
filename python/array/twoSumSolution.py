"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

"""
from typing import List


class TwoSumSolution:

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) < 2:
            return [0]
        res = {}
        # 构造索引
        for i in range(len(nums)):
            # 获取差，不存在放到res，存在就匹配到了
            need = target - nums[i]
            if need not in res.keys():
                res[nums[i]] = i
            else:
                return [i, res[need]]


# 测试
twoSumSolution = TwoSumSolution()
res = twoSumSolution.twoSum([2, 7, 11, 15], 9)
print(res)
