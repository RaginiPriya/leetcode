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
    
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        diam(root);
        return diameter;
    }
    
    private int diam(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = diam(node.left);
        int right = diam(node.right);
        
        diameter = Math.max(left + right, diameter);
        
        return 1 + Math.max(left, right);
    }
}