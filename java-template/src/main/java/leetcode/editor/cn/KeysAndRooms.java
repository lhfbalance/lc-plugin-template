/*
 * @lc app=leetcode.cn id=841 lang=java
 * @lcpr version=30403
 *
 * [841] 钥匙和房间
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KeysAndRooms {

    // @lc code=start
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Set<Integer> visited = new HashSet<>();

            Queue<Integer> queue = new LinkedList<>();
            visited.add(0);
            queue.offer(0);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i ++) {
                    Integer cur = queue.poll();
                    for(Integer room : rooms.get(cur)) {
                        if (!visited.contains(room)) {
                            visited.add(room);
                            queue.offer(room);
                        }
                    }
                }
            }
            return visited.size() == rooms.size();
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new KeysAndRooms().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1],[2],[3],[]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,3],[3,0,1],[2],[0]]\n
// @lcpr case=end

 */

