"""
77. 组合
"""
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        self.backtrack(n, k, 1, ans, [])
        return ans

    def backtrack(self, n: int, k: int, curr: int, ans: List[List[int]],
                  path: List[int]):
        if len(path) == k:
            ans.append(path[:])
            return

        for i in range(curr, n + 1):
            path.append(i)
            self.backtrack(n, k, i + 1, ans, path)
            path.pop()
