package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角-II
 * https://leetcode-cn.com/leetbook/read/array-and-string/ctyt1/
 * 知识点: 动态规划
 *
 * @author liuhj
 * @date 2021/12/11 14:54
 */
public class YangHuiTrianglePartTwo {

    public static List<Integer> getRow(int rowIndex) {
        int rows = rowIndex + 1;
        List<Integer> result = new ArrayList<>(rows);
        result.add(1);
        for (int i = 1; i < rows; i++) {
            int j = i / 2;
            for (; j > 0 && j < i; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
                result.set(i - j, result.get(j));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        int rowIndex = 10;
        List<Integer> integerList = getRow(rowIndex);
        System.out.println(integerList);
    }
}
