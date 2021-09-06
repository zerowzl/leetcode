import unittest

from .combinationSum import Solution


class TestSolution(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_combination_sum(self):
        ans = self.solution.combination_sum([2, 3, 6, 7], 7)
        self.assertEqual([[7], [2, 2, 3]], ans)

    def test_combination_sum_2(self):
        ans = self.solution.combination_sum([2, 3, 5], 8)
        self.assertEqual([[3, 5], [2, 3, 3], [2, 2, 2, 2]], ans)

    def test_combination_sum_3(self):
        ans = self.solution.combination_sum([2], 1)
        self.assertEqual([], ans)

    def test_combination_sum_4(self):
        ans = self.solution.combination_sum([1], 1)
        self.assertEqual([[1]], ans)


if __name__ == '__main__':
    unittest.main()
