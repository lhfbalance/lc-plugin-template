/*
 * @lc app=leetcode.cn id=763 lang=java
 * @lcpr version=30403
 *
 * [763] 划分字母区间
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PartitionLabels {

    // @lc code=start
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            // 每个字母在字符串中出现的最后一个位置
            for(int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = Math.max(last[s.charAt(i) - 'a'], i);
            }

            int start = 0;
            int end = 0;
            List<Integer> res = new LinkedList<>();
            
            for(int i = 0; i < s.length(); i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    res.add(end - start + 1);
                    start = end + 1;
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "ababcbacadefegdehijhklij"\n
// @lcpr case=end

// @lcpr case=start
// "eccbbbbdec"\n
// @lcpr case=end

 */

