/*
 * @lc app=leetcode.cn id=125 lang=java
 * @lcpr version=30403
 *
 * [125] 验证回文串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidPalindrome {

    // @lc code=start
    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            // 注意不能加=号
            while (left < right) {
                while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                    left++;
                }
                while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                    right--;
                }
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "A man, a plan, a canal: Panama"\n
// @lcpr case=end

// @lcpr case=start
// "race a car"\n
// @lcpr case=end

// @lcpr case=start
// " "\n
// @lcpr case=end

 */

