import unittest

from .subsets import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_combine_size_1(self):
        ans = self.solution.subsets([0])
        self.assertEqual([[], [0]], ans)

    def test_combine_size_2(self):
        ans = self.solution.subsets([1, 2, 3])
        self.assertEqual([[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]],
                         ans)


if __name__ == '__main__':
    unittest.main()
