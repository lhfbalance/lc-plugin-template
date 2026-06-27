/*
 * @lc app=leetcode.cn id=295 lang=java
 * @lcpr version=30403
 *
 * [295] 数据流的中位数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindMedianFromDataStream {

    // @lc code=start
    class MedianFinder {

        // 小顶堆，放大数据
        PriorityQueue<Integer> s = new PriorityQueue<>();
        // 大顶堆，放小数据
        PriorityQueue<Integer> b = new PriorityQueue<>((a,b) -> b - a);
    
        public MedianFinder() {
            
        }
        
        public void addNum(int num) {
            if (s.size() >= b.size()) {
                s.add(num);
                // 从 s 里过一道，把最小的拿出来给 b，保证 b 里的数据都小于s 里的数据
                b.add(s.poll());
            } else {
                b.add(num);
                // 从 b 里过一道，把最大的拿出来给 s，保证 s 里的数据都大于s 里的数据
                s.add(b.poll());
            }
        }
        
        public double findMedian() {
            if (s.size() > b.size()) {
                return s.peek();
            } else if (s.size() < b.size()) {
                return b.peek();
            } else {
                return (s.peek() + b.peek()) / 2.0d;
            }
            
        }
    }
    
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    // @lc code=end

    public static void main(String[] args) {
        // Solution solution = new FindMedianFromDataStream().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]\n
// @lcpr case=end

 */

