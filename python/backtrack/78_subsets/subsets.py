"""
78. 子集
"""
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        for k in range(len(nums) + 1):
            self.backtrack(nums, k, 0, ans, [])
        return ans

    def backtrack(self, nums: List[int], k: int, curr: int,
                  ans: List[List[int]], path: List[int]):
        if len(path) == k:
            ans.append(path[:])
            return

        for i in range(curr, len(nums)):
            path.append(nums[i])
            self.backtrack(nums, k, i + 1, ans, path)
            path.pop()
