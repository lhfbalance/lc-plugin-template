/*
 * @lc app=leetcode.cn id=155 lang=java
 * @lcpr version=30403
 *
 * [155] 最小栈
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinStacks {

    // @lc code=start
    class MinStack {

        // 用两个栈实现，最小栈维护当前元素进栈后的最小值
        Stack<Integer> minStack;
        Stack<Integer> stack;
        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }
        
        public void push(int val) {
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
            stack.push(val);
        }
        
        public void pop() {
            int val = stack.pop();
            if (minStack.peek().equals(val)) {
                minStack.pop();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    // @lc code=end

    public static void main(String[] args) {
        // Solution solution = new MinStack().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]\n
// @lcpr case=end

 */

