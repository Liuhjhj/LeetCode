package queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-median-from-data-stream/">数据流的中位数</a>
 * <p>知识点: 优先队列</p>
 *
 * @author liuhjhj
 * @date 2022/7/13 下午10:08
 */
public class FindMedianFromDataStream {

    static class MedianFinder {

        Queue<Integer> lowToHigh;
        Queue<Integer> highToLow;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            lowToHigh = new PriorityQueue<>();
            highToLow = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (highToLow.isEmpty() || num <= highToLow.peek()) {
                highToLow.offer(num);
                if (highToLow.size() > lowToHigh.size() + 1) {
                    lowToHigh.offer(highToLow.poll());
                }
            } else {
                lowToHigh.offer(num);
                if (lowToHigh.size() > highToLow.size()) {
                    highToLow.offer(lowToHigh.poll());
                }
            }
        }

        public double findMedian() {
            if (highToLow.size() > lowToHigh.size()) {
                return highToLow.peek();
            } else {
                return (highToLow.peek() + lowToHigh.peek()) / 2.0;
            }
        }
    }
/*
  Your MedianFinder object will be instantiated and called as such:
  MedianFinder obj = new MedianFinder();
  obj.addNum(num);
  double param_2 = obj.findMedian();
 */
}
