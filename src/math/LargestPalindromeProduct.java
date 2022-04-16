package math;

/**
 * <a href="https://leetcode-cn.com/problems/largest-palindrome-product/">最大回文数乘积</a>
 *
 * @author liuhjhj
 * @date 2022/4/16
 **/
public class LargestPalindromeProduct {

    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < n; i++) {
            sb.append("9");
        }
        long max = Long.parseLong(sb.toString());
        long min = (long) Math.pow(10, n - 1);
        for (long i = max; i >= min; i--) {
            sb = new StringBuilder(String.valueOf(i));
            String prefix = sb.toString();
            String suffix = sb.reverse().toString();
            long num = Long.parseLong(prefix + suffix);
            for (long j = max; j >= (long) Math.sqrt(num); j--) {
                if (num % j == 0 && num / j >= min && num / j <= max) {
                    return (int) (num % 1337);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int largestPalindrome = largestPalindrome(8);
        System.out.println(largestPalindrome);
    }
}
