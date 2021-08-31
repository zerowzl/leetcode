import unittest

from .removeDuplicatesFromSortedArray import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_removeDuplicates(self):
        ans = self.solution.removeDuplicates([1, 2, 10, 10, 11])
        self.assertEqual(4, ans)


if __name__ == '__main__':
    unittest.main()
