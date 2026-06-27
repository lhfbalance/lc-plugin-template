/*
 * @lc app=leetcode.cn id=347 lang=java
 * @lcpr version=30403
 *
 * [347] 前 K 个高频元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TopKFrequentElements {

    // @lc code=start
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freMap = new HashMap<>();
            for(int i = 0; i < nums.length ; i++) {
                if (freMap.containsKey(nums[i])) {
                    freMap.put(nums[i], freMap.get(nums[i]) + 1);
                } else {
                    freMap.put(nums[i], 1);
                }
            }

            // 计数排序的解法
            ArrayList<Integer>[] freqToVal = new ArrayList[nums.length + 1];
            for(Map.Entry<Integer, Integer> entry : freMap.entrySet()) {
                if (freqToVal[entry.getValue()] == null) {
                    freqToVal[entry.getValue()] = new ArrayList<>();
                }
                freqToVal[entry.getValue()].add(entry.getKey());
            }
            int[] res = new int[k];
            int j = 0;
            for(int i = freqToVal.length - 1; i > 0; i --) {
                // 数组中会有很多空档，注意判空
                if (freqToVal[i] != null) {
                    for(Integer integer : freqToVal[i]) {
                        res[j] = integer.intValue();
                        j++;
                        if (j == k) {
                            // 填充完成结果后返回即可
                            return res;
                        }
                    }
                }
                
                
            }
            return null;


            // 优先级队列的解法
            // PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            // for(Map.Entry<Integer, Integer> entry : freMap.entrySet()) {
            //     queue.add(entry);
            //     if (queue.size() > k) {
            //         queue.poll();
            //     }
            // }

            // int[] res = new int[queue.size()];
            // int i = 0;
            // while (!queue.isEmpty()) {
            //     res[i] = queue.poll().getKey();
            //     i++;
            // }
            
            // return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        int[] array = {1,1,1,2,2,3};
        solution.topKFrequent(array, 2);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,1,1,2,2,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,2,1,2,3,1,3,2]\n2\n
// @lcpr case=end

 */

