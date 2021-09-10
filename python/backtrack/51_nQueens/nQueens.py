"""
51. N 皇后
"""

from typing import List


class Solution:
    def solve_n_queens(self, n: int) -> List[List[str]]:

        # 生成答案
        def generate_board():
            board = list()
            # n 行
            for i in range(n):
                # queens[i] 就是皇后的索引
                row[queens[i]] = "Q"
                # 加入
                board.append("".join(row))
                # 恢复行
                row[queens[i]] = "."
            return board

        def backtrack(row: int):
            # row == n 说明每行的 queen 都有了
            if row == n:
                board = generate_board()
                solutions.append(board)
            else:
                # 每列都要尝试
                for i in range(n):
                    # 判断是否在列和两个斜边的路线上
                    if i in columns or row - i in diagonal1 or row + i in diagonal2:
                        continue
                    # 符合规则
                    queens[row] = i
                    columns.add(i)
                    diagonal1.add(row - i)
                    diagonal2.add(row + i)
                    backtrack(row + 1)
                    # 回溯回来了，恢复现场
                    columns.remove(i)
                    diagonal1.remove(row - i)
                    diagonal2.remove(row + i)

        solutions = list()
        # 保存每次路径皇后的索引，第一个是第一行。。。
        queens = [-1] * n
        # 皇后可以到达的列
        columns = set()
        # 皇后可以到达的从左向右的斜边，规律：同一斜边上的坐标，行坐标和列坐标的差相同
        diagonal1 = set()
        # 皇后可以到达的从右向左的斜边，规律：同一斜边上的坐标，行坐标和列坐标的和相同
        diagonal2 = set()
        # 生成答案时用到的行
        row = ["."] * n
        # 从第一行开始
        backtrack(0)
        return solutions
