package array.moveZeroes;

/* *****************************************************************************

283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

*******************************************************************************/

public class MoveZeroes {

    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int length = nums.length;

        while (i < length && j < length) {
            if (nums[i] == 0) {
                while (j < length) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        j++;
                        break;
                    }
                    j++;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }

        // System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes.moveZeroes(new int[]{0, 0, 0});
        moveZeroes.moveZeroes(new int[]{1, 0, 1});
        moveZeroes.moveZeroes(new int[]{1, 1, 1, 0, 0, 1});
        moveZeroes.moveZeroes(new int[]{1, 1, 1, 1});
    }
}