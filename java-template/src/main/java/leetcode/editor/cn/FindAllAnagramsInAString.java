/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30403
 *
 * [438] 找到字符串中所有字母异位词
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindAllAnagramsInAString {

    // @lc code=start
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int m = s.length();
            int n = p.length();
        
            Map<Character, Integer> tMap = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(int i= 0;i< n; i++) {
                Character key = p.charAt(i);
                tMap.put(key, tMap.getOrDefault(key, 0) + 1);
            }
            //窗口范围[left, right) ，左闭右开
            int left = 0;
            int right = 0;
            int size = 0;
            List<Integer> res = new LinkedList<>();
            while (right < m) {
                Character key = s.charAt(right);
                // 扩大窗口
                if (tMap.containsKey(key)) {
                    window.put(key, window.getOrDefault(key, 0) + 1);
                    if (window.get(key).equals(tMap.get(key))) {
                        size ++ ;
                    }
                }
                // 扩大窗口
                right++;

                // 缩小窗口
                while (right - left >= n) {
                    // 更新结果
                    if (size == tMap.size()) {
                        res.add(left);
                    }
                    // 待移出窗口的字符
                    Character tmpKey = s.charAt(left);
                    if (tMap.containsKey(tmpKey)) {
                        if (window.get(tmpKey).equals(tMap.get(tmpKey))) {
                            size--;
                        }
                        window.put(tmpKey, window.get(tmpKey) - 1);
                        
                    }
                    left ++;
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */

