import unittest

from .nQueensII import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_solve_n_queens(self):
        ans = self.solution.total_n_queens(4)
        self.assertEqual(2, ans)


if __name__ == '__main__':
    unittest.main()
