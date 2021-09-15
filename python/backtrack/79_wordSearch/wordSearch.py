"""
79. 单词搜索
"""
from typing import List


class Solution:
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def exist(self, board: List[List[str]], word: str) -> bool:
        h, w = len(board), len(board[0])
        visited = set()
        for i in range(h):
            for j in range(w):
                if self.check(board, word, visited, i, j, 0):
                    return True

        return False

    def check(self, board, word, visited, i: int, j: int, k: int) -> bool:
        if board[i][j] != word[k]:
            return False
        if k == len(word) - 1:
            return True

        visited.add((i, j))
        result = False
        for di, dj in self.directions:
            newi, newj = i + di, j + dj
            if 0 <= newi < len(board) and 0 <= newj < len(board[0]):
                if (newi, newj) not in visited:
                    if self.check(board, word, visited, newi, newj, k + 1):
                        result = True
                        break

        visited.remove((i, j))
        return result
