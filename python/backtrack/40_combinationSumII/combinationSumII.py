"""
40.组合总和 II
"""
from typing import List


class Solution:
    def combination_sum_2(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        先排序
        """
        candidates.sort()
        ans = []
        self.__backtrack(candidates, target, ans, [], 0, 0)
        return ans

    def __backtrack(self, candidates: List[int], target: int,
                    ans: List[List[int]], path: List[int], curr: int,
                    curr_sum: int):
        if curr_sum == target:
            # print(f"append {curr_sum} == {target}")
            ans.append(path[:])
            # print(ans)
            return

        for i in range(curr, len(candidates)):
            # print(f"进入第一层循环，i = {i}")
            if i > curr and candidates[i] == candidates[i - 1]:
                # print(f"i > curr 并且和 前一个元素一样，跳过i:{i}")
                continue

            # print(f"当前的和为{curr_sum}")
            if curr_sum + candidates[i] <= target:
                path.append(candidates[i])
                # print(
                    # f"{curr_sum + candidates[i]} 小于 target，添加进 path，path：{path}")
                self.__backtrack(candidates, target, ans, path, i + 1, curr_sum + candidates[i])
                path.pop()
                # print(f"回溯回来，pop，path：{path}")
