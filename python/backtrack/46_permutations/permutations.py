"""
46. 全排列
"""
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.backtrack(nums, ans, [])
        return ans

    def backtrack(self, nums: List[int], ans: List[List[int]], path: List[int]):
        if nums is None or len(nums) == 0:
            ans.append(path[:])
            return

        for i in range(0, len(nums)):
            path.append(nums[i])
            new_nums = []
            for j in range(0, len(nums)):
                if i != j:
                    new_nums.append(nums[j])
            self.backtrack(new_nums, ans, path)
            path.pop()
