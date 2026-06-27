/*
 * @lc app=leetcode.cn id=224 lang=java
 * @lcpr version=30403
 *
 * [224] 基本计算器
 */

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {

    // @lc code=start
    class Solution {
        public int calculate(String s) {

            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> startToEnd = new HashMap<>();
            for(int i = 0 ; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                }
                if (c == ')') {
                    startToEnd.put(stack.pop(), i);
                }
            }

            return subCalculate(s, 0, s.length() - 1, startToEnd);
            
        }

        int subCalculate(String s, int start, int end, Map<Integer, Integer> startToEnd) {
            Stack<Integer> stack = new Stack<>();
            char sign = '+';
            int num = 0;
            for(int i = start ; i <= end ; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                if (c == '(') {
                    num = subCalculate(s, i + 1, startToEnd.get(i) - 1, startToEnd);
                    i = startToEnd.get(i);
                }

                if (c == '+' || c == '-' || i == end) {
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
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
        Solution solution = new BasicCalculator().new Solution();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        // put your test code here

    }
}



/*
// @lcpr case=start
// "1 + 1"\n
// @lcpr case=end

// @lcpr case=start
// " 2-1 + 2 "\n
// @lcpr case=end

// @lcpr case=start
// "(1+(4+5+2)-3)+(6+8)"\n
// @lcpr case=end

 */

