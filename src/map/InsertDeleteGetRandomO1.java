package map;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 *
 * @author liuhjhj
 * @date 2022/3/6
 **/
public class InsertDeleteGetRandomO1 {

    class RandomizedSet {

        Map<Integer,Integer> map;
        List<Integer> list;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)){
                map.put(val,list.size());
                list.add(val);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)){
                int valIndex = map.get(val);
                int tailNum = list.get(list.size()-1);
                map.put(tailNum,valIndex);
                list.set(valIndex,tailNum);

                map.remove(val);
                list.remove(list.size()-1);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Random random = new Random();
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
