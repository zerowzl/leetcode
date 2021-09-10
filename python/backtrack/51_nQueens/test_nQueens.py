import unittest

from .nQueens import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_solve_n_queens(self):
        ans = self.solution.solve_n_queens(4)
        self.assertEqual([['.Q..', '...Q', 'Q...', '..Q.'],
                          ['..Q.', 'Q...', '...Q', '.Q..']], ans)


if __name__ == '__main__':
    unittest.main()
