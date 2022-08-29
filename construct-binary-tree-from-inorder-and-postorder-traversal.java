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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer, Integer> valToIndex = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            valToIndex.put(inorder[i], i);
        }
        return build(postorder, inorder, valToIndex, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] postorder, int[] inorder, Map<Integer, Integer> valToIndex, int inS, int inE, int poS, int poE){
        if(poS > poE || inS > inE){
            return null;
        }
        TreeNode node = new TreeNode(postorder[poE]);
        
        int index = valToIndex.get(node.val);
        
        int noOfRight = inE - index;
        
        node.left = build(postorder, inorder, valToIndex, inS, index - 1, poS, poE - 1 - noOfRight);
        node.right = build(postorder, inorder, valToIndex, index + 1, inE, poE - noOfRight, poE - 1);
        
        return node;
    }
}