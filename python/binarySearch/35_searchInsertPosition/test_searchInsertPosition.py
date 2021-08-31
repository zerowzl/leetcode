import unittest

from .searchInsertPosition import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_plusOne(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 5)
        self.assertEqual(2, ans)

    def test_plusOne_1(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 2)
        self.assertEqual(1, ans)

    def test_plusOne_2(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 7)
        self.assertEqual(4, ans)

    def test_plusOne_3(self):
        ans = self.solution.searchInsert([1, 3, 5, 6], 0)
        self.assertEqual(0, ans)

    def test_plusOne_4(self):
        ans = self.solution.searchInsert([1], 0)
        self.assertEqual(0, ans)


if __name__ == '__main__':
    unittest.main()
