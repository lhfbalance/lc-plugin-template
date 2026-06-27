/*
 * @lc app=leetcode.cn id=491 lang=java
 * @lcpr version=30403
 *
 * [491] 非递减子序列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NonDecreasingSubsequences {

    // @lc code=start
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> findSubsequences(int[] nums) {
            // Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums, 0);
            return res;
        }
        void backtrack(int[] nums , int start) {
            // if (path.size() == nums.length) {
            //     res.add(new LinkedList<>(path));
            //     // 到达叶子节点，返回
            //     return ;
            // }
            if (path.size() >= 2) {
                // 记录所有大于等于 2 的节点
                res.add(new LinkedList<>(path));
            }
            // 用哈希集合防止重复选择相同元素
            HashSet<Integer> used = new HashSet<>();
            for(int i = start; i<nums.length; i++) {
                
                if (!path.isEmpty() && path.getLast() > nums[i]) {
                    // 不满足递增条件，剪枝
                    continue;
                }
                // 左右相邻的树枝避免选择相同的值
                if(used.contains(nums[i])) {
                    continue;
                }
                used.add(nums[i]);
                path.addLast(nums[i]);
                

                backtrack(nums, i + 1);

                
                path.removeLast();
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        solution.findSubsequences(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [4,6,7,7]\n
// @lcpr case=end

// @lcpr case=start
// [4,4,3,2,1]\n
// @lcpr case=end

 */

