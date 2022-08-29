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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> valToIndex = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, inorder, valToIndex, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> valToIndex, int inS, int inE, int preS, int preE){
        if(preS > preE || inS > inE){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preS]);
        
        int index = valToIndex.get(node.val);
        
        int noOfLeft = index - inS;
        
        node.left = build(preorder, inorder, valToIndex, inS, index - 1, preS + 1, preS + noOfLeft);
        node.right = build(preorder, inorder, valToIndex, index + 1, inE, preS + 1 + noOfLeft, preE);
        
        return node;
    }
}