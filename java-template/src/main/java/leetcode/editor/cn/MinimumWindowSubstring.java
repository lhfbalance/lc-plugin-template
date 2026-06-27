/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30403
 *
 * [76] 最小覆盖子串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumWindowSubstring {

    // @lc code=start
    class Solution {
    public String minWindow(String s, String t) {
            int m = s.length();
            int n = t.length();
            if(m < n) {
                return "";
            }
            Map<Character, Integer> tMap = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(int i= 0;i< n; i++) {
                Character key = t.charAt(i);
                tMap.put(key, tMap.getOrDefault(key, 0) + 1);
            }
            //窗口范围[left, right) ，左闭右开
            int left = 0;
            int right = 0;
            // 辅助判断窗口是否可缩小，因为有重复字符，所以不能用两个 map 的 size 简单的比较
            int size = 0;
            // 保存结果的索引
            int resLeft = 0;
            int resRight = 0;
            // 记录满足条件最小窗口
            int minLength = m;
            while (right < m) {
                Character key = s.charAt(right);
                // 扩大窗口
                window.put(key, window.getOrDefault(key, 0) + 1);
                if (tMap.containsKey(key) && window.get(key).equals(tMap.get(key)) ) {
                    size ++ ;
                }
                // 扩大窗口
                right++;

                // 缩小窗口
                while (size == tMap.size() && left < right) {
                    // 更新结果
                    if (right - left <= minLength) {
                        minLength = right - left;
                        resRight = right;
                        resLeft = left;
                    }
                    // 待移出窗口的字符
                    Character tmpKey = s.charAt(left);
                    window.put(tmpKey, window.get(tmpKey) - 1);
                    // 这里可以用小于判断，原因是进到这个 while 循环是，size == tMap.size() ，window 里的 value 一定大于等于 tmap 里的 value
                    if (tMap.containsKey(tmpKey) && window.get(tmpKey) < tMap.get(tmpKey)) {
                        size--;
                    }
                    left ++;
                }
            }
            return s.substring(resLeft, resRight);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here
        System.out.println(solution.minWindow("dinitrophenylhydrazinetrinitrophenylmethylnitramine","trinitrophenylmethylnitramine"));

    }
}



/*
// @lcpr case=start
// "ADOBECODEBANC"\n"ABC"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"aa"\n
// @lcpr case=end

 */

