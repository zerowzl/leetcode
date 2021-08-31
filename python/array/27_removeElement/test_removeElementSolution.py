import unittest

from .removeElementSolution import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_removeDuplicates(self):
        ans = self.solution.removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2)
        self.assertEqual(5, ans)


if __name__ == '__main__':
    unittest.main()
