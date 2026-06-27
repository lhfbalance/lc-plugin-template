/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30403
 *
 * [17] 电话号码的字母组合
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LetterCombinationsOfAPhoneNumber {

    // @lc code=start
    class Solution {
        static Map<Character, List<String>> digitalTochar = new HashMap<>();
        static {
            digitalTochar.put('2', Arrays.asList("a", "b", "c"));
            digitalTochar.put('3', Arrays.asList("d", "e", "f"));
            digitalTochar.put('4', Arrays.asList("g", "h", "i"));
            digitalTochar.put('5', Arrays.asList("j", "k", "l"));
            digitalTochar.put('6', Arrays.asList("m", "n", "o"));
            digitalTochar.put('7', Arrays.asList("p", "q", "r", "s"));
            digitalTochar.put('8', Arrays.asList("t", "u", "v"));
            digitalTochar.put('9', Arrays.asList("w", "x", "y", "z"));
        }
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        public List<String> letterCombinations(String digits) {
            backtrack(digits, 0);
            return res;
        }
        void backtrack(String digits, int start) {
            if (start == digits.length()) {
                res.add(path.toString());
                return;
            }

            // 每个数字的可选范围
            for(String s : digitalTochar.get(digits.charAt(start))) {
                // 做选择
                path.append(s);

                backtrack(digits, start + 1);

                // 撤销选择
                path.deleteCharAt(path.length() - 1);
                
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

