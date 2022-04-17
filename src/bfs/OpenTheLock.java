package bfs;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/open-the-lock/">打开转盘锁</a>
 * <p>知识点: 深/广度优先遍历</p>
 *
 * @author liuhj
 * @date 2021/12/12 14:29
 */
public class OpenTheLock {

    public static int openLock(String[] deadEnds, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> seen = new HashSet<>(8);
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>(8);
        dead.addAll(Arrays.asList(deadEnds));
        if (dead.contains("0000")) {
            return -1;
        }
        queue.offer("0000");
        seen.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.remove();
                List<String> nextStatus = getNextStatus(status);
                for (String state : nextStatus) {
                    if (!dead.contains(state) && !seen.contains(state)) {
                        if (state.equals(target)){
                            return step;
                        }
                        queue.offer(state);
                        seen.add(state);
                    }
                }
            }
        }
        return -1;
    }

    public static char numAdd(char ch) {
        return ch == '9' ? '0' : (char) (ch + 1);
    }

    public static char numSub(char ch) {
        return ch == '0' ? '9' : (char) (ch - 1);
    }

    public static List<String> getNextStatus(String status) {
        List<String> result = new ArrayList<>(8);
        char[] chars;
        for (int i = 0; i < status.length(); i++) {
            chars = status.toCharArray();
            chars[i] = numAdd(chars[i]);
            result.add(new String(chars));
            chars = status.toCharArray();
            chars[i] = numSub(chars[i]);
            result.add(new String(chars));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] deadEnds = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        int i = openLock(deadEnds, target);
        System.out.println(i);
    }
}
