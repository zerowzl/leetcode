#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) < 2:
            return [0]
        res = {}
        for i in range(len(nums)):
            need = target - nums[i]
            if need not in res.keys():
                res[nums[i]] = i
            else:
                return [i, res[need]]
# @lc code=end
