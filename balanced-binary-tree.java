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
    
    static class Height {
        int height;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new Height());
    }
    
    private boolean isBalanced(TreeNode node, Height h){
        if(node == null){
            return true;
        }
        Height lh = new Height();
        Height rh = new Height();
        boolean left = isBalanced(node.left, lh);
        boolean right = isBalanced(node.right, rh);
        if(!left || !right || Math.abs(lh.height - rh.height) > 1){
            return false;
        }
        
        h.height = Math.max(rh.height, lh.height) + 1;
        return true;
        
    }
}