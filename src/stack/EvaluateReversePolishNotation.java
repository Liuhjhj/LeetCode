package stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * @author liuhj
 * @date 2021/12/19 22:26
 */
public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String ch : tokens) {
            if (isNumber(ch)) {
                stack.push(Integer.valueOf(ch));
            } else {
                Integer integer1 = stack.pop();
                Integer integer2 = stack.pop();
                stack.push(operateNum(integer2, integer1, ch));
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String ch) {
        return !"+".equals(ch) && !"-".equals(ch) && !"*".equals(ch) && !"/".equals(ch);
    }

    public static Integer operateNum(Integer integer1, Integer integer2, String operator) {
        if ("+".equals(operator)) {
            return integer1 + integer2;
        } else if ("-".equals(operator)) {
            return integer1 - integer2;
        } else if ("*".equals(operator)) {
            return integer1 * integer2;
        } else if ("/".equals(operator)) {
            return integer1 / integer2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] strings = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int evalRPN = evalRPN(strings);
        System.out.println(evalRPN);
    }
}
