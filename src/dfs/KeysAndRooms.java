package dfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 *
 * @author liuhj
 * @date 2022/1/15 22:35
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> result = new HashSet<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int top = stack.pop();
                result.add(top);
                for (int j = 0; j < rooms.get(top).size(); j++) {
                    int key = rooms.get(top).get(j);
                    if (!result.contains(key)){
                        stack.push(key);
                    }
                }
            }
        }
        result = result.stream().filter(key -> key!=0).collect(Collectors.toSet());
        return result.size() == rooms.size() - 1;
    }
}
