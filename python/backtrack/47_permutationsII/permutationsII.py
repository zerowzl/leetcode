"""
47. 全排列 II
"""
from typing import List


class Solution:
    def permute_unique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        self.backtrack(nums, ans, [])
        return ans

    def backtrack(self, nums: List[int], ans: List[List[int]], path: List[int]):
        if nums is None or len(nums) == 0:
            ans.append(path[:])
            return

        for i in range(0, len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            path.append(nums[i])
            new_nums = []
            for j in range(0, len(nums)):
                if i != j:
                    new_nums.append(nums[j])
            self.backtrack(new_nums, ans, path)
            path.pop()
