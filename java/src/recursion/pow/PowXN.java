package recursion.pow;


/* *****************************************************************************

50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000

示例 2：
输入：x = 2.10000, n = 3
输出：9.26100

示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2^-2 = 1/2^2 = 1/4 = 0.25

提示：
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= x^n <= 10^4

*******************************************************************************/

/* *****************************************************************************

题解：
递归 + 二分法

复杂度分析：
时间复杂度：O(log n)
空间复杂度：O(log n)

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class PowXN {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        System.out.println(solution.myPow(2.0000d, 10));
        System.out.println(solution.myPow(2.10000d, 3));
        System.out.println(solution.myPow(2.00000d, -2));
        System.out.println(solution.myPow(34.00515d, -3));
    }


}
