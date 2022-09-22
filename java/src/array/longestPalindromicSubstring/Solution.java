package array.longestPalindromicSubstring;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String ans = "";
        // 中心扩展法
        for (int i = 0; i < s.length(); i++) {
            String s1 = find(s, i, i);
            String s2 = find(s, i, i + 1);
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        return ans;
    }

    private String find(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}