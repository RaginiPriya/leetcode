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
    
    TreeNode prev = null;
    int count = 0;
    int maxCount = 0;
    
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    private void inorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        inorder(node.left, list);
        count = (prev != null && node.val == prev.val) ? count + 1 : 1;
        
        if(count == maxCount){
            list.add(node.val);
        }
        else if(count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(node.val);
        }

        prev = node;
        inorder(node.right, list);
    }
}