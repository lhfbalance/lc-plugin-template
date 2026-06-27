/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30403
 *
 * [239] 滑动窗口最大值
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SlidingWindowMaximum {

    // @lc code=start
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            MaxQueue maxQueue = new MaxQueue();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < k ; i++) {
                // 把窗口填满
                maxQueue.push(nums[i]);
            }
            res.add(maxQueue.max());
            for(int i= k; i < nums.length; i ++) {
                maxQueue.push(nums[i]);
                maxQueue.pop(nums[i-k]);
                res.add(maxQueue.max());
            }
            int[] relRes = new int[res.size()];
            for(int i = 0; i < res.size(); i++) {
                relRes[i] = res.get(i);
            }
            
            return relRes;
        }
    }

    /**
     * 单调队列 — 队列前面放的一定都是比我大的，如果比我小，可以删除掉，没用
     */
    class MaxQueue {
        List<Integer> list = new LinkedList<>();

        // 在队尾添加元素
        void push(int i) {
            
            while (!list.isEmpty() && list.getLast() < i) {
                // 直接删除掉，没用
                list.removeLast();
            }
            list.addLast(i);
        }

        // 队列中的最大值，队列头永远最大，在 push 的时候维护的
        int max() {
            return list.getFirst();
        }

        // 队列头如果是 n，删除它，需要这个函数的原因是避免多删
        void pop(int n) {
            if (!list.isEmpty() && list.getFirst() == n) {
                list.removeFirst();
            }
        }

    }

    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        // put your test code here
        int[] array = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(array, 3);

    }
}



/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

