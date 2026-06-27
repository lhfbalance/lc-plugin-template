/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30403
 *
 * [20] 有效的括号
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidParentheses {

    // @lc code=start
    class Solution {
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } 
                if (c == ')') {
                    if (stack.isEmpty() || !stack.pop().equals('(')) {
                        return false;
                    }
                }
                if (c == '}') {
                    if (stack.isEmpty() || !stack.pop().equals('{')) {
                        return false;
                    }
                }
                if (c == ']') {
                    if (stack.isEmpty() || !stack.pop().equals('[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "()[]{}"\n
// @lcpr case=end

// @lcpr case=start
// "(]"\n
// @lcpr case=end

// @lcpr case=start
// "([])"\n
// @lcpr case=end

// @lcpr case=start
// "([)]"\n
// @lcpr case=end

 */

