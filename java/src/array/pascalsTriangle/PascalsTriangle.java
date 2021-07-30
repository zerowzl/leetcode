package array.pascalsTriangle;

/* *****************************************************************************

118. 杨辉三角
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
在「杨辉三角」中，每个数是它左上方和右上方的数的和。

示例 1:
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 
示例 2:
输入: numRows = 1
输出: [[1]]
 
提示:
 1 <= numRows <= 30

*******************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dave Wang
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>(i + 1);
            List<Integer> pre = res.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    rows.add(pre.get(j - 1) + pre.get(j));
                }
            }

            res.add(rows);
        }

        return res;
    }
}
