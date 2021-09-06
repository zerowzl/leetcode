"""
39.组合总和
"""
from typing import List


class Solution:
    def combination_sum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        self.__backtrack(candidates, target, ans, [], 0)
        return ans

    def __backtrack(self, candidates: List[int], target: int,
                    ans: List[List[int]], path: List[int], curr: int):

        if target == 0:
            ans.append(path[:])
            return

        if target < 0 or curr >= len(candidates):
            return

        # 不用
        self.__backtrack(candidates, target, ans, path, curr + 1)

        # 用
        curr_target = target - candidates[curr]
        if curr_target >= 0:
            path.append(candidates[curr])
            self.__backtrack(candidates, curr_target, ans, path, curr)
            path.remove(candidates[curr])
