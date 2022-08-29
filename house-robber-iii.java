/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap();
        return rob(root, map);
    }
    
    private int rob(TreeNode node, Map<TreeNode, Integer> map){
        if(node == null){
            return 0;
        }
        Integer dp = map.get(node);
        if(dp != null){
            return dp;
        }
        int val = 0;
        
        if(node.left != null){
            val += rob(node.left.left, map);
            val += rob(node.left.right, map);
        }
        if(node.right != null){
            val += rob(node.right.left, map);
            val += rob(node.right.right, map);
        }
        
        int res = Math.max(val + node.val, rob(node.left, map) + rob(node.right, map));
        map.put(node, res);
        
        return res;
        
    }
}