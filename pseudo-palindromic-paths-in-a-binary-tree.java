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
    public int pseudoPalindromicPaths (TreeNode root) {
        
        Set<Integer> set = new HashSet<>();
        return pseudo(root, set);
        
    }
    
    private int pseudo(TreeNode node, Set<Integer> set){
        if(node == null){
            return 0;
        }
        boolean isAdd = false;
        if(set.contains(node.val)){
            set.remove(node.val);
        }
        else{
            set.add(node.val);
            isAdd = true;
        }
        int val = 0;
        if(node.left == null && node.right == null && set.size() <= 1){
            val = 1;
        }
        int left = pseudo(node.left, set);
        int right = pseudo(node.right, set);
        if(isAdd){
            set.remove(node.val);
        }
        else{
            set.add(node.val);
        }
        return left + right + val;
    }
}