package sort;

import java.util.Arrays;

/**
 * 冒泡排序。 
 *
 * @author Dave Wang
 */
public class BubbleSort {
    
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            // -i表示，去掉排序好的元素；-1表示跟下一个元素对比，所以不能走到最头上。
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        sort(new int[]{5,1,8,2,4,8,4,0,3});
    }
    
    
    
}
