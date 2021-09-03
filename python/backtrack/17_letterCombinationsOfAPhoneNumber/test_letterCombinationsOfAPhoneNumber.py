import unittest

from .letterCombinationsOfAPhoneNumber import Solution


class MyTestCase(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_letter_combinations(self):
        ans = self.solution.letter_combinations("23")
        self.assertEqual(["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"],
                         ans)

    def test_letter_combinations_empty(self):
        ans = self.solution.letter_combinations("")
        self.assertEqual([], ans)


if __name__ == '__main__':
    unittest.main()
