/*
 * @lc app=leetcode.cn id=319 lang=java
 * @lcpr version=30403
 *
 * [319] 灯泡开关
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BulbSwitcher {

    // @lc code=start
    class Solution {
        public int bulbSwitch(int n) {
            // 只有 1，4，9，16，25 这些特殊的数，会被按奇数次
            return (int)Math.sqrt(n);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BulbSwitcher().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

