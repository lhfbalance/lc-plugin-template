/*
 * @lc app=leetcode.cn id=208 lang=java
 * @lcpr version=30403
 *
 * [208] 实现 Trie (前缀树)
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ImplementTriePrefixTree {

    // @lc code=start
    class Trie {

        public static class TrieNode {
            TrieNode[] chirldren = new TrieNode[26];
            boolean flag;
        }

        TrieNode root = new TrieNode();
    
        public Trie() {
            
        }
        
        public void insert(String word) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                if (p.chirldren[c - 'a'] == null) {
                    // 不存在子节点，新建一个
                    p.chirldren[c - 'a'] = new TrieNode();
                }
                p = p.chirldren[c - 'a'];
            }
            p.flag = true;
        }
        
        public boolean search(String word) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                if (p.chirldren[c - 'a'] == null) {
                    return false;
                }
                p = p.chirldren[c - 'a'];
            }
            return p.flag;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for(char c : prefix.toCharArray()) {
                if (p.chirldren[c - 'a'] == null) {
                    return false;
                }
                p = p.chirldren[c - 'a'];
            }
            return true;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    // @lc code=end

    public static void main(String[] args) {
        // Solution solution = new ImplementTriePrefixTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]\n
// @lcpr case=end

 */

