/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30403
 *
 * [416] 分割等和子集
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PartitionEqualSubsetSum {

    // @lc code=start
    class Solution {

        public boolean canPartition(int[] nums) { 
            int sum = 0;
            for(int i=0; i< nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                // 为奇数，一定不能分割
                return false;
            }
            sum = sum/2;
            // 定义状态，就是数组元素的和
            // 定义选择，元素要不要选
            // 定义 dp 数组的含义: 仅仅使用前 i 个元素是否能组成和为 j 的数字，i 从 1 开始
            // 找到状态转移的逻辑
            boolean dp[] = new boolean[sum + 1];
            // base case
            dp[0] = true;
            

            for(int i = 1; i< nums.length + 1; i ++) {
                for(int j = sum; j >= 0; j--) {
                    int k = j - nums[i - 1];
                    if(k >=0) {
                        // 这个或很精髓
                        dp[j] = dp[j] || dp[k];
                    }
                    if (j == sum && dp[j] == true) {
                        // 只要找到一个符合要求的组合即可返回
                        return true;
                    }
                }
            }
            
            return dp[sum];
        }

        public boolean canPartition1(int[] nums) {
            int sum = 0;
            for(int i=0; i< nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                // 为奇数，一定不能分割
                return false;
            }
            sum = sum/2;
            // 定义状态，就是数组元素的和
            // 定义选择，元素要不要选
            // 定义 dp 数组的含义: 仅仅使用前 i 个元素是否能组成和为 j 的数字，i 从 1 开始
            // 找到状态转移的逻辑
            boolean dp[][] = new boolean[nums.length + 1][sum + 1];
            // base case
            for(int i = 0; i < dp.length; i ++) {
                // base case，？？？？
                dp[i][0] = true;
            }

            for(int i = 1; i< dp.length; i ++) {
                for(int j = 1; j < dp[i].length; j ++) {
                    
                    if(j - nums[i - 1] < 0) {
                        // 只能不选
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 选择第 i 个元素 或 不选第 i 个元素    
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                    }
                    if (j == sum && dp[i][j] == true) {
                        // 只要找到一个符合要求的组合即可返回
                        return true;
                    }
                }
            }
            // for(int i = 1; i < dp.length; i ++) {
            //     if (dp[i][sum]) {
            //         return true;
            //     }
            // }
            return dp[nums.length][sum];
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        int[] aa = {1,5,11,5};
        solution.canPartition(aa);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,5,11,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,5]\n
// @lcpr case=end

 */

