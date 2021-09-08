import unittest

from .permutations import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_permute_two_size(self):
        ans = self.solution.permute([1, 2])
        self.assertEqual([[1, 2], [2, 1]], ans)

    def test_permute_three_size(self):
        ans = self.solution.permute([1, 2, 3])
        self.assertEqual(
            [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]],
            ans)


if __name__ == '__main__':
    unittest.main()
