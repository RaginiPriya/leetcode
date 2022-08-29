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
    
    //1 2   3   4
    
    public TreeNode balanceBST(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<>();
        inorder(list, root);
        return rec(list, 0, list.size() - 1);
    }
    
    private void inorder(List<TreeNode> list, TreeNode node){
        if(node == null){
            return;
        }
        inorder(list, node.left);
        list.add(node);
        inorder(list, node.right);
    }
    
    private TreeNode rec(List<TreeNode> list, int start, int end){
        if(start > end){
            return null;
        }
        int middle = start + (end - start) / 2;
        
        TreeNode node = list.get(middle);
        
        node.left = rec(list, start, middle - 1);
        node.right = rec(list, middle + 1, end);
        
        return node;
    }
    
}