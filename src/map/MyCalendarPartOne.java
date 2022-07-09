package map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/my-calendar-i/">我的日程安排表 I</a>
 *
 * @author liuhjhj
 * @date 2022/7/9 下午10:01
 */
public class MyCalendarPartOne {

    static class MyCalendar {
        Map<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if (map.isEmpty()){
                map.put(start,end);
                return true;
            }

            int low = -1;
            int high = -1;

            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                if (key < start) {
                    low = key;
                } else if (key > start) {
                    high = key;
                    break;
                } else {
                    return false;
                }
            }
            if (low >= 0 && map.get(low) > start){
                return false;
            }
            if (high > 0 && (map.get(high) < end || high < end)){
                return false;
            }
            map.put(start, end);
            return true;
        }
    }
}
