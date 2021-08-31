import unittest

from .pascalsTriangle import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_generate(self):
        ans = self.solution.generate(3)
        self.assertEqual([[1], [1, 1], [1, 2, 1]], ans)


if __name__ == '__main__':
    unittest.main()
