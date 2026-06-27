/*
 * @lc app=leetcode.cn id=227 lang=java
 * @lcpr version=30403
 *
 * [227] 基本计算器 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BasicCalculatorIi {

    // @lc code=start
    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char sign = '+';
            int num = 0;
            for(int i = 0 ; i <= s.length() - 1 ; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                

                if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                    int pre = 0;
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            pre = stack.pop();
                            num = pre * num;
                            stack.push(num);
                            break;
                        case '/':
                            pre = stack.pop();
                            num = pre / num;
                            stack.push(num);
                            break;
                        default:
                            break;
                    }
                    sign = c;
                    num = 0;
                }  
            }

            int res = 0;
            while (!stack.isEmpty()) {
                res = res + stack.pop();
            }

            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        solution.calculate("3+2*2");
        // put your test code here

    }
}



/*
// @lcpr case=start
// "3+2*2"\n
// @lcpr case=end

// @lcpr case=start
// " 3/2 "\n
// @lcpr case=end

// @lcpr case=start
// " 3+5 / 2 "\n
// @lcpr case=end

 */

