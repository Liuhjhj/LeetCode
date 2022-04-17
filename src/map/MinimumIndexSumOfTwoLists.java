package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/">两个列表的最小索引总和</a>
 *
 * @author liuhjhj
 * @date 2022/2/26
 **/
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],-i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])){
                Integer index = map.get(list2[i]);
                index = -index;
                int sumIndex = index+i;
                if (min > sumIndex){
                    min = sumIndex;
                }
                map.put(list2[i], sumIndex);
            }
        }
        List<String> result = new ArrayList<>();
        int finalMax = min;
        map.forEach((key, value)->{
            if (value == finalMax){
                result.add(key);
            }
        });
        return result.toArray(new String[0]);
    }
}
