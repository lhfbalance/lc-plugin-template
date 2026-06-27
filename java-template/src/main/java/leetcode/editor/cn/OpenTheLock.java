/*
 * @lc app=leetcode.cn id=752 lang=java
 * @lcpr version=30403
 *
 * [752] 打开转盘锁
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class OpenTheLock {

    // @lc code=start
    class Solution {
        public int openLock(String[] deadends, String target) {

            Set<String> deadsSet = new HashSet<>();
            deadsSet.addAll(Arrays.asList(deadends));
            if (deadsSet.contains("0000")) {
                return -1;
            }

            Queue<String> queue = new LinkedList<>();
            int step = 0;

            Set<String> visited = new HashSet<>();
            visited.add("0000");
            queue.offer("0000");

            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i< size;i++) {

                    String cur = queue.poll();

                    if (target.equals(cur)) {
                        return step;
                    } else {
                        // 八叉树
                        for(String next : getNeighbor(cur)) {
                            if (visited.contains(next)) {
                                // 避免成环
                                continue;
                            }
                            if (deadsSet.contains(next)) {
                                // 遇到了死亡数字，不允许走这条路
                                continue;
                            }
                            // 加入到 visited 里
                            visited.add(next);
                            queue.offer(next);
                        }
                    }    
                }
                // 本层没找到，要去下一层寻找
                step ++;
            }

            
            return -1;
        }

        List<String> getNeighbor(String origin){
            char[] orignCharArray = origin.toCharArray();
            List<String> res = new LinkedList<>();
            // 往下拨
            for(int i = 0; i < orignCharArray.length; i++) {
                char temp = orignCharArray[i];
                orignCharArray[i] = (char)((orignCharArray[i] - '0' + 1)%10 + '0');
                res.add(new String(orignCharArray));
                // 恢复进入下个循环
                orignCharArray[i] = temp;
            }

            // 往上拨
            for(int i = 0; i < orignCharArray.length; i++) {
                char temp = orignCharArray[i];
                orignCharArray[i] = (char)((orignCharArray[i] - '0' + 10 - 1)%10 + '0');
                res.add(new String(orignCharArray));
                // 恢复进入下个循环
                orignCharArray[i] = temp;
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
        //System.out.println(solution.getNeighbor("1111"));
        String[] deadends = {"8888"};
        solution.openLock(deadends, "0009");
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["0201","0101","0102","1212","2002"]\n"0202"\n
// @lcpr case=end

// @lcpr case=start
// ["8888"]\n"0009"\n
// @lcpr case=end

// @lcpr case=start
// ["8887","8889","8878","8898","8788","8988","7888","9888"]\n"8888"\n
// @lcpr case=end

 */

