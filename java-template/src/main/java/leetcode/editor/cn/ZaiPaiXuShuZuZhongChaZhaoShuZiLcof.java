/*
 * @lc app=leetcode.cn id=LCR 172 lang=java
 * @lcpr version=30403
 *
 * [LCR 172] 统计目标成绩的出现次数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    // @lc code=start
    class Solution {
        public int countTarget(int[] nums, int target) {
            if (nums == null) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            int leftBound = -1;
            int rightBound = -1;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] == target) {
                    // 让搜索区间逐步缩小至等于 target 的右侧侧
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            //  left 是大于 target 的最小索引，rigght 是最后一个 target 的索引
            // while 循环结束 right < left 即 right = left 减 1；
            if (right >= 0 && right < nums.length && nums[right] == target) {
                rightBound = right;
            }
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] == target) {
                    // 让搜索区间逐步缩小至等于 target 的左侧
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            // right 是小于 target 的最大所以，left 是第一个 targe 的索引
            // while 循环结束 right < left 即 right = left 减 1；
            if (left >= 0 && left < nums.length && nums[left] == target) {
                leftBound = left;
            }
            return rightBound == -1 ? 0 : (rightBound - leftBound + 1);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,2,3,4,4,4,5,6,6,8]\n4\n
// @lcpr case=end

 */

