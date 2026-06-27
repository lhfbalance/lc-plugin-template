/*
 * @lc app=leetcode.cn id=242 lang=java
 * @lcpr version=30403
 *
 * [242] 有效的字母异位词
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidAnagram {

    // @lc code=start
    class Solution {
        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> count = new HashMap<>();

            for(int i=0; i< s.length();i++ ) {
                count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
                count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
            }

            for(Character c : count.keySet()) {
                if (count.get(c) != 0) {
                    return false;
                }
            }
            return true;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "anagram"\n"nagaram"\n
// @lcpr case=end

// @lcpr case=start
// "rat"\n"car"\n
// @lcpr case=end

 */

