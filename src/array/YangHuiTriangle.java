package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * https://leetcode-cn.com/leetbook/read/array-and-string/cuj3m/
 * 知识点: 动态规划
 *
 * @author liuhj
 * @date 2021/12/11 14:42
 */
public class YangHuiTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> first = new ArrayList<>(1);
        first.add(1);
        result.add(first);
        if (numRows == 1){
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows =5;
        List<List<Integer>> lists = generate(numRows);
        System.out.println(lists);
    }
}
