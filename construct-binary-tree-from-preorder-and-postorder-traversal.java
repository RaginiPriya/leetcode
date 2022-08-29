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
    
    int pre = 0;
    int pos = 0;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        TreeNode node = new TreeNode(preorder[pre++]);
        
        if(node.val != postorder[pos]){
            // left tree needs to be constructed
            node.left = constructFromPrePost(preorder, postorder);
        }
        
        if(node.val != postorder[pos]){
            // left tree needs to be constructed
            node.right = constructFromPrePost(preorder, postorder);
        }
        
        pos++;
        return node;
    }
}