/*
 * @lc app=leetcode.cn id=384 lang=java
 * @lcpr version=30403
 *
 * [384] 打乱数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ShuffleAnArray {

    // @lc code=start
    class Solution {
        private int[] nums;
        private Random random;

        public Solution() {}
    
        public Solution(int[] nums) {
            this.nums  = nums;
            this.random = new Random();
        }
        
        public int[] reset() {
            return nums;
        }
        
        public int[] shuffle() {
            int[] tmp = new int[nums.length];
            System.arraycopy(nums, 0, tmp, 0, nums.length);
            for(int i = 0; i < tmp.length; i++) {
                // 生成一个[i,n)之间的随机数，确保i 可以和之后的任意一个数字交换；
                int r = random.nextInt(i, tmp.length);
                swap(tmp, i, r);
            }
            return tmp;
            
        }

        private void swap(int[] array, int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
    
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ShuffleAnArray().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]\n
// @lcpr case=end

 */

