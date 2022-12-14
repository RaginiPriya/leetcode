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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }
    
    private void preorder(List<Integer> result, TreeNode node){
        if(node == null){
            return;
        }
        
        preorder(result, node.left);
        preorder(result, node.right);
        result.add(node.val);
    }
}