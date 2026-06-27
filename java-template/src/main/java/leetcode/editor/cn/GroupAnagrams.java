/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30403
 *
 * [49] 字母异位词分组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class GroupAnagrams {

    // @lc code=start
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for(String string : strs) {
                String key = encode(string);
                if (map.containsKey(key)) {
                    map.get(key).add(string);
                } else {
                    List<String> group = new LinkedList<>();
                    group.add(string);
                    map.put(key, group);
                }
            }

            return map.values().stream().toList();
            
        }

        private String encode(String s) {
            if (s == null) {
                return null;
            }
            char[] res = new char[26];
            for(int i = 0 ; i < s.length();i++) {
                res[s.charAt(i) - 'a'] ++;
            }
            return new String(res);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["eat","tea","tan","ate","nat","bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */

