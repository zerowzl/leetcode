package binarySearch.firstBadVersion;

/* *****************************************************************************

278. 第一个错误的版本

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            boolean b = isBadVersion(mid);
            if (b) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(5));
    }
}
