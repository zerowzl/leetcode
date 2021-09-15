import unittest

from .wordSearch import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_exist_size_1(self):
        ans = self.solution.exist([["A"]], "A")
        self.assertTrue(ans)

    def test_exist_size_2(self):
        ans = self.solution.exist([["A", "B"],
                                   ["A", "B"]], "AB")
        self.assertTrue(ans)

        ans = self.solution.exist([["A", "B"],
                                   ["A", "B"]], "ABBA")
        self.assertTrue(ans)

        ans = self.solution.exist([["A", "B"],
                                   ["A", "B"]], "BB")
        self.assertTrue(ans)

        ans = self.solution.exist([["A", "B"],
                                   ["A", "B"]], "BBA")
        self.assertTrue(ans)

        ans = self.solution.exist([["A", "B"],
                                   ["A", "B"]], "BA")
        self.assertTrue(ans)

    def test_exist_size_3(self):
        ans = self.solution.exist([["A", "B", "C", "E"],
                                   ["S", "F", "C", "S"],
                                   ["A", "D", "E", "E"]], "ABCCED")
        self.assertTrue(ans)


if __name__ == '__main__':
    unittest.main()
