/*
 * @lc app=leetcode.cn id=567 lang=java
 * @lcpr version=30403
 *
 * [567] 字符串的排列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PermutationInString {

    // @lc code=start
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            Map<Character, Integer> target = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(int i = 0; i < s1.length(); i ++) {
                target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i), 0) + 1);
            }
            int left = 0;
            int right = 0;
            int realSize = 0;

            while (right - left < s1.length() && right < s2.length()) {
                char c = s2.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (target.containsKey(c) 
                    && window.get(c).equals(target.get(c))) {
                    realSize ++;
                }
                right ++ ;
                
                while (right - left >= s1.length()) {
                    if (realSize == target.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    
                    // 这里要先判断是否相等，然后再真正的移除和窗口扩大时正好相反，和 76 题有差别，这里不能用小于来判断，因为 while 循环里没有realSize == target.size()
                    // 所以还是套框架比较好
                    if (target.containsKey(d) && window.get(d).equals(target.get(d))) {
                        realSize --;
                    }
                    window.put(d, window.get(d) - 1);
                    left++;
                }
                
            }
            return false;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here
        System.out.println(solution.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));

    }
}



/*
// @lcpr case=start
// "ab"\n"eidbaooo"\n
// @lcpr case=end

// @lcpr case=start
// "ab"\n"eidboaoo"\n
// @lcpr case=end

 */

