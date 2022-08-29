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
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode node, int val){
        if(node == null){
            return 0;
        }
        val = val * 2 + node.val;
        
        if(node.left == null && node.right == null){
            return val;
        }
        
        return sum(node.left, val) + sum(node.right, val);
    }
}