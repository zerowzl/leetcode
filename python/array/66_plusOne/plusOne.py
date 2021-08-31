"""
66.加一

给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：
    输入：digits = [1,2,3]
    输出：[1,2,4]
    解释：输入数组表示数字 123。

示例 2：
    输入：digits = [4,3,2,1]
    输出：[4,3,2,2]
    解释：输入数组表示数字 4321。

示例 3：
    输入：digits = [0]
    输出：[1]

提示：
    1 <= digits.length <= 100
    0 <= digits[i] <= 9

"""
from typing import List


class Solution:

    def plusOne(self, digits: List[int]) -> List[int]:
        """
        从后往前遍历 digits，对每个元素进行 +1然后取模赋值。如果值 != 0 说明不没有进位，结束遍历；
        反之说明有进位，直到遍历完 digits，在下标 0 的地方插入一个1。
        一次遍历 O(n)，没有额外的空间使用。
        """
        for i in range(len(digits) - 1, -1, -1):
            digits[i] = (digits[i] + 1) % 10
            if digits[i] != 0:
                return digits
        digits.insert(0, 1)
        return digits
