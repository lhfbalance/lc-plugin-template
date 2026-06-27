/*
 * @lc app=leetcode.cn id=232 lang=java
 * @lcpr version=30403
 *
 * [232] 用栈实现队列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ImplementQueueUsingStacks {

    // @lc code=start
    class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;
    
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void push(int x) {
            s2.push(x);
        }
        
        public int pop() {
            if (s1.isEmpty()) {
                peek();
            }
            return s1.pop();
            
        }
        
        public int peek() {
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            return s1.peek();
            
        }
        
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    // @lc code=end

    public static void main(String[] args) {
        MyQueue solution = new ImplementQueueUsingStacks().new MyQueue();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]\n
// @lcpr case=end

 */

