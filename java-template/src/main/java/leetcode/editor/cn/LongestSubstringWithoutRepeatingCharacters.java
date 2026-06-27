/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30403
 *
 * [3] 无重复字符的最长子串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestSubstringWithoutRepeatingCharacters {

    // @lc code=start
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int m = s.length();
        
            Set<Character> window = new HashSet<>();
            
            //窗口范围[left, right) ，左闭右开
            int left = 0;
            int right = 0;
            int res = 0;
            while (right < m) {
                Character c = s.charAt(right);
                // 扩大窗口
                if (!window.contains(c)) {
                    window.add(c);
                    right++;
                    // 更新结果
                    res = Math.max(right - left, res);
                } else {
                    // 缩小窗口
                    while (window.contains(c)) {
                        // 待移出窗口的字符
                        Character d = s.charAt(left);
                        window.remove(d);
                        left++;
                    }
                }
                
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

