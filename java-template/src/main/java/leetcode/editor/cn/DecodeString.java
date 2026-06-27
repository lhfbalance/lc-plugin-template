/*
 * @lc app=leetcode.cn id=394 lang=java
 * @lcpr version=30403
 *
 * [394] 字符串解码
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DecodeString {

    // @lc code=start
    class Solution {
        public String decodeString(String s) {
            
            Stack<Integer> integers = new Stack<>();
            Stack<String> strings = new Stack<>();
            int i = 0;
            Integer tempInteger = 1;
            StringBuilder tempString = new StringBuilder();
            while (i < s.length()) {
                
                if (Character.isDigit(s.charAt(i))) {
                    StringBuilder d = new StringBuilder();
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        // 数字
                        d.append(s.charAt(i));
                        i++;
                        
                    }
                    tempInteger = Integer.valueOf(d.toString());
                } else if (s.charAt(i) == '[') {
                    // 前缀字符进栈，默认是空字符
                    strings.push(tempString.toString());
                    tempString = new StringBuilder();
                    // 压数字进栈
                    integers.push(tempInteger);
                    tempInteger = 1;
                    i++;
                } else if (s.charAt(i) == ']') {
                    // 数字出栈
                    int k = integers.pop();
                    // 前缀字符出栈
                    StringBuilder sb = new StringBuilder(strings.pop());
                    for(int j = 0; j< k;j++) {
                        // 重复当前字符n 次
                        sb.append(tempString);
                    }
                    // 将前缀加重复 n 次后的字符串
                    tempString = sb;
                    i++;                    
                    
                } else {
                    StringBuilder pre = new StringBuilder();
                    while (i < s.length() && Character.isLowerCase(s.charAt(i)) ) {
                        // 字符
                        pre.append(s.charAt(i));
                        i++;
                    }
                    
                    tempString.append(pre);
                    
                }
            }
            return tempString.toString();
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        solution.decodeString("2[abc]3[cd]ef");
        // put your test code here

    }
}



/*
// @lcpr case=start
// "3[a]2[bc]"\n
// @lcpr case=end

// @lcpr case=start
// "3[a2[c]]"\n
// @lcpr case=end

// @lcpr case=start
// "2[abc]3[cd]ef"\n
// @lcpr case=end

 */

