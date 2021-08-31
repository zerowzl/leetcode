import unittest

from .plusOne import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_plusOne(self):
        ans = self.solution.plusOne([9, 9, 9, 9])
        self.assertEqual([1, 0, 0, 0, 0], ans)

    def test_plusOne_1(self):
        ans = self.solution.plusOne([0, 9, 9, 9])
        self.assertEqual([1, 0, 0, 0], ans)


if __name__ == '__main__':
    unittest.main()
