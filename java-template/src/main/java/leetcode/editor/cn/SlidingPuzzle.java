/*
 * @lc app=leetcode.cn id=773 lang=java
 * @lcpr version=30403
 *
 * [773] 滑动谜题
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SlidingPuzzle {

    // @lc code=start
    class Solution {
        int[][] neighbors = {
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {3,1,5},
            {4,2},
        };
        public int slidingPuzzle(int[][] board) {

            StringBuilder origin = new StringBuilder();
            for(int i = 0; i < board.length; i++) {
                for(int j=0; j< board[0].length; j++) {
                    origin.append(board[i][j]);
                }
            }

            String target = "123450";
            HashSet<String> visited = new HashSet<>();

            Queue<String> queue = new LinkedList<>();
            int depth = 0;
            
            String originString = origin.toString();
            visited.add(originString);
            queue.add(originString);

            while (!queue.isEmpty()) {
                int size = queue.size();
                
                for(int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if (cur.equals(target)) {
                        // 找到答案
                        return depth;
                    } else {
                        int indexOf0 = cur.indexOf("0");
                        for(int neighbor : neighbors[indexOf0]) {
                            // 把所有可能加入到队列里
                            String next = swap(cur, indexOf0, neighbor);
                            if (visited.contains(next)) {
                                // 避免环路
                                continue;
                            }
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    
                }

                depth++;
            }
            
            return -1;
        }

        String swap(String s, int indexOf0, int otherIndex) {
            char[] res = s.toString().toCharArray();
            res[indexOf0] = res[otherIndex];
            res[otherIndex] = '0';
            return new String(res);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
        int[][] array = {{1,2,3},{4,0,5}};
        solution.slidingPuzzle(array);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,2,3],[4,0,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[5,4,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[4,1,2],[5,0,3]]\n
// @lcpr case=end

 */

