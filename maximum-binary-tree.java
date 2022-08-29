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
    
    // 3 2 1 6 0 5
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int index = -1;
        int max = -1;
        
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        
        TreeNode node = new TreeNode(max);
        node.left = construct(nums, left, index - 1);
        node.right = construct(nums, index + 1, right);
        return node;
    }
}