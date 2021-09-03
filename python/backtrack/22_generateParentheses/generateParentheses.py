"""
22. 括号生成

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 
有效括号组合需满足：左括号必须以正确的顺序闭合。

示例 1：
 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
  
示例 2：
    输入：n = 1
    输出：["()"]
  
提示：
   1 <= n <= 8 
  
"""
from typing import List


class Solution:
    def generate_parenthesis(self, n: int) -> List[str]:
        if not n:
            return []
        ans = []
        self.__backtrack(ans, "", n, 0, 0)
        return ans

    def __backtrack(self, ans: List[str], s: str, n: int, left: int,
                    right: int):
        if right == n:
            ans.append(s[:])
        else:
            if left < n:
                s = s + "("
                self.__backtrack(ans, s, n, left + 1, right)
                s = s[:-1]

            if right < left:
                s = s + ")"
                self.__backtrack(ans, s, n, left, right + 1)
