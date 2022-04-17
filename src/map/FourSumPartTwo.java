package map;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/4sum-ii/">四数之和-II</a>
 *
 * @author liuhjhj
 * @date 2022/3/5
 **/
public class FourSumPartTwo {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int j : nums1) {
            for (int k : nums2) {
                if (map.containsKey(j + k)) {
                    map.put(j + k, map.get(j + k) + 1);
                } else {
                    map.put(j + k, 1);
                }
            }
        }
        for (int j : nums3) {
            for (int k : nums4) {
                if (map.containsKey(-(j + k))) {
                    result += map.get(-(j + k));
                }
            }
        }
        return result;
    }
}
