/*
 * @lc app=leetcode.cn id=387 lang=java
 * @lcpr version=30403
 *
 * [387] 字符串中的第一个唯一字符
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FirstUniqueCharacterInAString {

    // @lc code=start
    class Solution {
        public int firstUniqChar(String s) {

            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length();i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }

            for(int i = 0; i < s.length();i++) {
                if (map.get(s.charAt(i)).equals(1)) {
                    return i;
                }
            }
            return -1;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "leetcode"\n
// @lcpr case=end

// @lcpr case=start
// "loveleetcode"\n
// @lcpr case=end

// @lcpr case=start
// "aabb"\n
// @lcpr case=end

 */

