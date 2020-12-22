"""
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

"""

from typing import List


class PascalsTriangleSolution:
    """
    循环numRows次，
    第一个和每列的第一个和最后一个元素赋值1
    其他元素去上层去找，[索引]=上一层[索引] + 上一层[索引-1]
    """

    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        pre = None
        for i in range(numRows):
            if i == 0:
                one = [1]
                res.append(one)
                pre = one
            elif i == 1:
                two = [1, 1]
                res.append(two)
                pre = two
            else:
                arr = []
                for j in range(i + 1):
                    if j == 0 or j == i:
                        arr.append(1)
                    else:
                        arr.append(pre[j] + pre[j - 1])
                res.append(arr)
                pre = arr
        return res


solution = PascalsTriangleSolution()
print(solution.generate(5))
