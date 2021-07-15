package binarySearch.binarySearch;

/* *****************************************************************************

704.二分查找

*******************************************************************************/

/**
 * @author Dave Wang
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
