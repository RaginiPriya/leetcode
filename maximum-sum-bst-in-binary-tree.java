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
    
    int max = 0;
    
    public int maxSumBST(TreeNode root) {
        maxSum(root);
        return max;
    }
    
    private int[] maxSum(TreeNode node){
        if(node == null){
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        int[] left = maxSum(node.left);
        int[] right = maxSum(node.right);
        
        if(left == null || left[2] >= node.val || right == null || right[1] <= node.val){
            return null;
        }
        
        int val = node.val + left[0] + right[0];
        
        max = Math.max(max, val);
        
        return new int[]{val, Math.min(left[1], node.val), Math.max(node.val, right[2])};
    }
}