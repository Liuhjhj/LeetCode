package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/">每日温度</a>
 *
 * @author liuhj
 * @date 2021/12/19 21:11
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length;) {
            if (stack.isEmpty() || temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
                i++;
            }else if (temperatures[i]>temperatures[stack.peek()]){
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {55,38,53,81,61,93,97,32,43,78};
        int[] dailyTemperatures = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(dailyTemperatures));
    }
}
