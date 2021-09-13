import unittest

from .combinations import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_combine_size_1(self):
        ans = self.solution.combine(1, 1)
        self.assertEqual([[1]], ans)

    def test_combine_size_2(self):
        ans = self.solution.combine(2, 1)
        self.assertEqual([[1], [2]], ans)

    def test_combine_size_4(self):
        ans = self.solution.combine(4, 2)
        self.assertEqual([[1, 2],
                          [1, 3],
                          [1, 4],
                          [2, 3],
                          [2, 4],
                          [3, 4]], ans)


if __name__ == '__main__':
    unittest.main()
