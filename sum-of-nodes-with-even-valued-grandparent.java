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
    public int sumEvenGrandparent(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int val = 0;
        
        if(root.val % 2 == 0){
            if(root.left != null){
                if(root.left.left != null){
                    val += root.left.left.val;
                }
                if(root.left.right != null){
                    val += root.left.right.val;
                }
            }
            if(root.right != null){
                if(root.right.left != null){
                    val += root.right.left.val;
                }
                if(root.right.right != null){
                    val += root.right.right.val;
                }
            }
        }
        
        return val + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}