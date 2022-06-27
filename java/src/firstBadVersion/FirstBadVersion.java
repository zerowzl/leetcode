package firstBadVersion;

/**
 * <a href="https://leetcode.cn/problems/first-bad-version/">第一个错误版本</a>
 *
 * @author Dave Wang
 */
public class FirstBadVersion {

    /**
     * 二分查找，找到第一个小于等于的索引
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n, ans = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 如果是错误的版本，则继续从左边查找
            if (isBadVersion(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 只是为了防止编译错误，运行结果不正确
     */
    public boolean isBadVersion(int version) {
        return false;
    }
}
