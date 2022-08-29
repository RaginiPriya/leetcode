/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode ans = null;
    
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        
        if(node == null){
            return null;
        }
        
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        
        if(ans != null){
            return ans;
        }
        
        int val = 0;
        if(node == p || node == q){
            val++;
        }
        
        if(left != null){
            val++;
        }
        
        if(right != null){
            val++;
        }
        
        if(val == 2){
            ans = node;
        }
        
        if(val == 0){
            return null;
        }
        
        return node;
    }

}