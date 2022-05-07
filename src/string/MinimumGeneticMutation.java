package string;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-genetic-mutation/">最小基因变化</a>
 *
 * @author liuhjhj
 * @date 2022/5/7
 **/
public class MinimumGeneticMutation {

    public static void main(String[] args) {
//        String start = "AACCGGTT", end = "AACCGGTA";
//        String[] bank = {"AACCGGTA"};
//        String start = "AACCGGTT", end = "AAACGGTA";
//        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
//        String start = "AAAAACCC", end = "AACCCCCC";
//        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        String start = "AAAACCCC", end = "CCCCCCCC";
        String[] bank = {"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"};
        int i = minMutation(start, end, bank);
        System.out.println(i);
    }

    public static int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (!bankSet.contains(end)) {
            return -1;
        }
        int result = 0;
        Set<String> seen = new HashSet<>();
        seen.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        char[] genetics = {'A', 'G', 'C', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                String string = queue.remove();
                for (int j = 0; j < string.length(); j++) {
                    StringBuilder sb = new StringBuilder(string);
                    for (char genetic : genetics) {
                        sb.setCharAt(j, genetic);
                        if (seen.contains(sb.toString()) || !bankSet.contains(sb.toString())) {
                            continue;
                        }
                        if (sb.toString().equals(end)) {
                            return result;
                        }
                        queue.add(sb.toString());
                        seen.add(sb.toString());
                    }
                }
            }
        }
        return -1;
    }
}
