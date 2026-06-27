/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30403
 *
 * [300] 最长递增子序列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestIncreasingSubsequence {

    // @lc code=start
    class Solution {

        // 二分法
        public int lengthOfLIS(int[] nums) {
            // 堆的数量
            int piles = 0;
            // 每个堆最上方的数字，最上方最小
            int[] top = new int[nums.length];
            
            for(int i = 0; i < nums.length; i++) {
                // 使用左闭合右开的方式进行二分搜索，结束条件是 left == right
                int left = 0, right = piles;
                // 找num[i]在 top 里的左边界[2,3,4,8]
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (top[mid] > nums[i]) {
                        // 右边界不包含 mid
                        right = mid;
                    } else if (top[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        // 要找左边界，所以收缩右边界，右边界不包含 mid
                        right = mid;
                    }
                }
                // left移到了最右边，说 top[]的数都比 num[i]小
                if (left == piles) {
                    // 需要新建对没找到比num[i]小的
                    piles ++;
                } 
                top[left] = nums[i];
                
            }
            return piles;

        }
        public int lengthOfLIS2(int[] nums) {
            // 定义 dp 数组，dp(i)是以 nums[i]结尾的递增序列的长度
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int res = dp[0];
            for(int i = 1; i < nums.length; i++) {
                // dp[i] 至少是 1
                dp[i] = 1;
                for(int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // dp[i] 已经有值，可以更新最终结果
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        public int lengthOfLIS1(int[] nums) {
            memo = new int[nums.length];
            Arrays.fill(memo, 0);
            int res = 0;
            for(int i = 0; i < nums.length ; i++) {
                res = Math.max(res, dp(i, nums));
            }
            return res;
        }
        int[] memo;
        // 定义 dp 函数，dp(i)是以 nums[i]结尾的递增序列的长度
        int dp(int i, int[] nums) {
            if (memo[i] != 0) {
                return memo[i];
            }
            if (i == 0) {
                return 1;
            }
            int subRes=0;
            for(int k = i - 1; k >= 0; k--) {
                if (nums[k] < nums[i]) {
                    subRes = Math.max(subRes, dp(k, nums) + 1);
                }
            }
            memo[i] = (subRes == 0 ? 1 : subRes);
            return memo[i];

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [10,9,2,5,3,7,101,18]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,0,3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7,7,7,7]\n
// @lcpr case=end

 */

