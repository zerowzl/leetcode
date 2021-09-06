import unittest

from .combinationSumII import Solution


class TestSolution(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_combination_sum(self):
        ans = self.solution.combination_sum_2([10, 1, 2, 7, 6, 1, 5], 8)
        self.assertEqual([[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]], ans)

    def test_combination_sum_2(self):
        ans = self.solution.combination_sum_2([6, 2, 6], 8)
        self.assertEqual([[2, 6]], ans)


if __name__ == '__main__':
    unittest.main()
