package array;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode-cn.com/problems/array-of-doubled-pairs/">二倍数对数组</a>
 *
 * @author liuhjhj
 * @date 2022/4/1
 **/
public class ArrayOfDoubledPairs {

    public static boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> positiveMap = new TreeMap<>();
        Map<Integer, Integer> negativeMap = new TreeMap<>();
        for (int i : arr) {
            if (i > 0) {
                if (positiveMap.containsKey(i)) {
                    positiveMap.put(i, positiveMap.get(i) + 1);
                } else {
                    positiveMap.put(i, 1);
                }
            } else {
                i = Math.abs(i);
                if (negativeMap.containsKey(i)) {
                    negativeMap.put(i, negativeMap.get(i) + 1);
                } else {
                    negativeMap.put(i, 1);
                }
            }
        }
        return traverseMap(positiveMap) && traverseMap(negativeMap);
    }

    public static boolean traverseMap(Map<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            if (value == 0) {
                iterator.remove();
                continue;
            }
            if (key == 0) {
                if (value % 2 == 1) {
                    return false;
                } else {
                    iterator.remove();
                }
            }
            int doubleKey = key * 2;
            if (map.containsKey(doubleKey)) {
                iterator.remove();
                Integer doubleNumCount = map.get(doubleKey);
                if (doubleNumCount < value) {
                    return false;
                } else {
                    map.put(doubleKey, doubleNumCount - value);
                }
            }
        }
        return map.isEmpty();
    }
}
