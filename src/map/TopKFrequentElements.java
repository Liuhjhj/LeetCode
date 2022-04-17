package map;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">前 K 个高频元素</a>
 *
 * @author liuhjhj
 * @date 2022/3/5
 **/
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map.entrySet().stream().sorted((o1,o2)->o2.getValue().compareTo(o1.getValue())).limit(k).mapToInt(Map.Entry::getKey).toArray();

    }
}
