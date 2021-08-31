import unittest

from .twoSum import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_something(self):
        ans = self.solution.twoSum([2, 7, 11, 15], 9)
        self.assertEqual(ans, [1, 0])


if __name__ == '__main__':
    unittest.main()
