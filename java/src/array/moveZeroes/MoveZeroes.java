package array.moveZeroes;

class MoveZeroes {
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