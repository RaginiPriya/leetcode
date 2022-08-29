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
    
    int level = 1;
    Integer ans = null;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    
    private void inorder(TreeNode node, int k){
        if(node == null){
            return;
        }
        
        inorder(node.left, k);
        if(ans != null){
            return;
        }
        if(level == k){
            ans = node.val;
            return;
        }
        level++;
        inorder(node.right, k);
    }
}