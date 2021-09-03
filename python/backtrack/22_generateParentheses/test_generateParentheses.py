import unittest

from .generateParentheses import Solution


class TestSolution(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_generate_parenthesis(self):
        ans = self.solution.generate_parenthesis(1)
        self.assertEqual(["()"], ans)

    def test_generate_parenthesis_2(self):
        ans = self.solution.generate_parenthesis(2)
        self.assertEqual(["(())", "()()"], ans)


if __name__ == '__main__':
    unittest.main()
