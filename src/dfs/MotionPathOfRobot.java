package dfs;

/**
 * <a href="https://leetcode.cn/leetbook/read/illustration-of-algorithm/9h6vo2/">剑指 Offer 13. 机器人的运动范围</a>
 *
 * @author liuhjhj
 * @date 2022/6/21 22:37
 **/
public class MotionPathOfRobot {

    public static int movingCount(int m, int n, int k) {
        boolean[][] seen = new boolean[m][n];
        int result = 0;
        dfs(m, n, 0, 0, k, seen);
        for (boolean[] booleans : seen) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void dfs(int m, int n, int x, int y, int k, boolean[][] seen) {
        if (!notOutOfIndex(m, n, x, y) || !access(x, y, k) || seen[x][y]) {
            return;
        }
        seen[x][y] = true;
        dfs(m, n, x + 1, y, k, seen);
        dfs(m, n, x - 1, y, k, seen);
        dfs(m, n, x, y + 1, k, seen);
        dfs(m, n, x, y - 1, k, seen);
    }

    public static boolean access(int x, int y, int k) {
        return (x / 10) + (x % 10) + (y / 10) + (y % 10) <= k;
    }

    public static boolean notOutOfIndex(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
