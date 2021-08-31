"""
118.杨辉三角

给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。

示例 1:
    输入: numRows = 5
    输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

示例 2:
    输入: numRows = 1
    输出: [[1]]

提示:
    1 <= numRows <= 30

"""

from typing import List


class Solution:

    def generate(self, numRows: int) -> List[List[int]]:
        """
        循环numRows次，
        第一个和每列的第一个和最后一个元素赋值1
        其他元素去上层去找，[索引]=上一层[索引] + 上一层[索引-1]
        """
        triangle = []
        for row_num in range(numRows):
            # 第一个和最后一个都是1
            row = [None for _ in range(row_num + 1)]
            row[0], row[-1] = 1, 1

            # 其他元素和上一行的左边1个和当前位置相加的和
            for j in range(1, len(row) - 1):
                row[j] = triangle[row_num - 1][j - 1] + triangle[row_num - 1][j]

            triangle.append(row)
        return triangle
