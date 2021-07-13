package array.mergeIntervals;

/* *****************************************************************************

56.合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 

示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 
示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

提示：
 1 <= intervals.length <= 104
 intervals[i].length == 2 
 0 <= starti <= endi <= 104 

*******************************************************************************/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dave Wang
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        List<SortArray> sortArrays = new ArrayList<>(intervals.length);
        for (int[] interval : intervals) {
            sortArrays.add(new SortArray(interval, interval[0]));
        }
        sortArrays.sort(Comparator.comparingInt(SortArray::getSort));

        int size = sortArrays.size();
        boolean b;
        List<SortArray> merge = sortArrays;
        do {
            merge = merge(merge);
            b = size != merge.size();
            size = merge.size();
            if (size == 1) {
                break;
            }
        } while (b);

        int[][] res = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            res[i] = merge.get(i).getArray();
        }
        return res;
    }

    private List<SortArray> merge(List<SortArray> sortArrays) {
        List<SortArray> temp = new ArrayList<>();
        SortArray curr = sortArrays.get(0);
        for (int i = 1; i < sortArrays.size(); i++) {
            int end = curr.getArray()[1];
            SortArray next = sortArrays.get(i);
            if (end >= next.getSort()) {
                temp.add(new SortArray(
                        new int[]{curr.getArray()[0], Integer.max(curr.getArray()[1], next.getArray()[1])},
                        curr.getArray()[0]));
                if (i == sortArrays.size() - 1) {
                    break;
                }
                curr = sortArrays.get(++i);
            } else {
                temp.add(curr);
                curr = next;
            }
            if (i >= sortArrays.size() - 1) {
                temp.add(curr);
                break;
            }
        }
        return temp;
    }


    class SortArray {

        int[] array;
        int sort;

        public SortArray(int[] array, int sort) {
            this.array = array;
            this.sort = sort;
        }

        public int[] getArray() {
            return array;
        }

        public void setArray(int[] array) {
            this.array = array;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
