"""
52. N 皇后 II
"""


class Solution:
    def total_n_queens(self, n: int) -> int:
        def backtrack(row: int):
            # row == n 说明每行的 queen 都有了
            if row == n:
                return 1
            else:
                count = 0
                # 每列都要尝试
                for i in range(n):
                    # 判断是否在列和两个斜边的路线上
                    if i in columns or row - i in diagonal1 or row + i in diagonal2:
                        continue
                    # 符合规则
                    columns.add(i)
                    diagonal1.add(row - i)
                    diagonal2.add(row + i)
                    count += backtrack(row + 1)
                    # 回溯回来了，恢复现场
                    columns.remove(i)
                    diagonal1.remove(row - i)
                    diagonal2.remove(row + i)
                return count

        # 皇后可以到达的列
        columns = set()
        # 皇后可以到达的从左向右的斜边，规律：同一斜边上的坐标，行坐标和列坐标的差相同
        diagonal1 = set()
        # 皇后可以到达的从右向左的斜边，规律：同一斜边上的坐标，行坐标和列坐标的和相同
        diagonal2 = set()
        # 从第一行开始
        count = backtrack(0)
        return count
