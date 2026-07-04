/*
 * @lc app=leetcode.cn id=297 lang=java
 * @lcpr version=30403
 *
 * [297] 二叉树的序列化与反序列化
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class SerializeAndDeserializeBinaryTree {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        
    
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializePostOrder(root, sb);
            return sb.toString();
        }

        // 后序位置
        private void serializePostOrder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(",");
                return;
            }
            
            
            serialize(root.left, sb);
            

            serialize(root.right, sb);
            
            
            sb.append(root.val);
        }

        // 前序位置
        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#");
                return;
            }
            sb.append(root.val);
            sb.append(",");
            serialize(root.left, sb);

            sb.append(",");
            serialize(root.right, sb);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<Integer> list = new LinkedList<>();
            for(String d : data.split(",")) {
                if ("#".equals(d)) {
                    list.add(null);
                } else {
                    list.add(Integer.valueOf(d));
                }
            }
            
            
            return deserialize(list);

        }


        public TreeNode deserialize(List<Integer> list) {
            if (list.isEmpty()) {
                return null;
            }

            Integer val =  list.removeFirst();
            if (val == null) {
                return null;
            }
            TreeNode node = new TreeNode(val.intValue());
            node.left = deserialize(list);
            node.right = deserialize(list);
            return node;
        }
    }
    
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    // @lc code=end

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
        Codec codec = tree.new Codec();
        Integer[] arr = {1,2,3,null,null,4,5};
        System.out.println(codec.serialize(TreeNode.createRoot(arr)));

        // String s = "1,2,3";
        // String ss = "1,2,3,";
        // String[] res1 = s.split(",");
        // String[] res2 = ss.split(",");
        // System.out.println(res1);
        // System.out.println(res2);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,null,null,4,5]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

