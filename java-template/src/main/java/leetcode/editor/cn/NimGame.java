/*
 * @lc app=leetcode.cn id=292 lang=java
 * @lcpr version=30403
 *
 * [292] Nim 游戏
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NimGame {

    // @lc code=start
    class Solution {
        public boolean canWinNim(int n) {
            if (n % 4 == 0) {
                return false;
            }
            return true;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NimGame().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 2\n
// @lcpr case=end

 */

