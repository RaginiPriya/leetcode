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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        
        return lca(root, p, q);
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        // if(node == null){
        //     return null;
        // }
        // if(p.val < node.val && q.val > node.val){
        //     return node;
        // }
        // if(p.val > node.val && q.val > node.val){
        //     return lca(node.right, p, q);
        // }
        // return lca(node.left, p, q);
        
        if(root.val < p.val && root.val < q.val){
            return lca(root.right, p, q);
        }
        if(root.val > p.val && root.val > q.val){
            return lca(root.left, p, q);
        }
        else{
            return root;
        }
    }
}