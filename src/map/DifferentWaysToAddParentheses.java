package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/">为运算表达式设计优先级</a>
 *
 * @author liuhjhj
 * @date 2022-07-07 00:33:32
 */
public class DifferentWaysToAddParentheses {
    public static final Integer ADD = -1;
    public static final Integer SUB = -2;
    public static final Integer MUL = -3;

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>(expression.length());

        String regex = "[+\\-*]+";
        List<Integer> nums = Arrays.stream(expression.split(regex))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        regex = "\\d+";
        List<Integer> ops = Arrays.stream(expression.split(regex))
                .skip(1)
                .map(op -> {
                    if ("-".equals(op)) {
                        return SUB;
                    } else if ("+".equals(op)) {
                        return ADD;
                    } else if ("*".equals(op)) {
                        return MUL;
                    }
                    return 0;
                }).collect(Collectors.toList());
        for (int i = 0; i < nums.size(); i++) {
            list.add(nums.get(i));
            if (i < ops.size()) {
                list.add(ops.get(i));
            }
        }
        List<Integer>[][] dp = new ArrayList[list.size()][list.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < list.size(); i += 2) {
            dp[i][i].add(list.get(i));
        }

        for (int i = 3; i <= list.size(); i += 2) {
            for (int j = 0; j + i <= list.size(); j += 2) {
                int right = i + j - 1;
                for (int k = j + 1; k < right; k += 2) {
                    List<Integer> leftList = dp[j][k - 1];
                    List<Integer> rightList = dp[k + 1][right];
                    for (Integer leftNum : leftList) {
                        for (Integer rightNum : rightList) {
                            if (Objects.equals(list.get(k), SUB)) {
                                dp[j][right].add(leftNum - rightNum);
                            } else if (Objects.equals(list.get(k), ADD)) {
                                dp[j][right].add(leftNum + rightNum);
                            } else if (Objects.equals(list.get(k), MUL)) {
                                dp[j][right].add(leftNum * rightNum);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][list.size() - 1];
    }

    public static void main(String[] args) {
        List<Integer> integers = diffWaysToCompute("21-32+40");
        System.out.println(integers);
    }
}