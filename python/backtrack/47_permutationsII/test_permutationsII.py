import unittest

from .permutationsII import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_permute_unique_two_size(self):
        ans = self.solution.permute_unique([1, 1])
        self.assertEqual([[1, 1]], ans)

    def test_permute_unique_three_size(self):
        ans = self.solution.permute_unique([1, 1, 2])
        self.assertEqual(
            [[1, 1, 2], [1, 2, 1], [2, 1, 1]], ans)


if __name__ == '__main__':
    unittest.main()
