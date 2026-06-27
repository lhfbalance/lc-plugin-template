/*
 * @lc app=leetcode.cn id=204 lang=java
 * @lcpr version=30403
 *
 * [204] 计数质数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CountPrimes {

    // @lc code=start
    class Solution {
        public int countPrimes(int n) {
            boolean[] primes = new boolean[n];
            Arrays.fill(primes, true);
            for(int i = 2; i * i < n; i++) {
                if (primes[i]) {
                    for(int j = i * i; j < n ; j = j + i) {
                        primes[j] = false;
                    }
                }
            }

            int res = 0;
            for(int i = 2; i < n; i++) {
                if (primes[i]) {
                    res++;
                }
            }
            return res;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 10\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

