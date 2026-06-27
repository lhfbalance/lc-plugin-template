/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30403
 *
 * [146] LRU 缓存
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LruCache {

    // @lc code=start
    class LRUCache {

        LinkedHashMap<Integer, Integer> innerCache;
        int capacity;
        int size = 0;
    
        public LRUCache(int capacity) {
            this.innerCache = new LinkedHashMap<>();
            this.capacity = capacity;
        }
        
        public int get(int key) {
            if (innerCache.containsKey(key)) {
                int res = innerCache.get(key);
                // 放到列表头
                innerCache.remove(key);
                innerCache.putFirst(key, res);
                return res;
            }
            
            return -1;
        }
        
        public void put(int key, int value) {
            // put的时候先看下是否包含，如果包含则覆盖，且移动到头
            if (innerCache.containsKey(key)) {
                // 放到列表头
                innerCache.remove(key);
                innerCache.putFirst(key, value);
            } else {
                // 不包含的情况下，put 到头，且检测 size 是否超限
                innerCache.putFirst(key, value);
                size++;
                if (size > capacity) {
                    innerCache.remove(innerCache.lastEntry().getKey());
                    size--;
                }
            }
            
            
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    // @lc code=end

    public static void main(String[] args) {
        // Solution solution = new LruCache().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]\n
// @lcpr case=end

 */

