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
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private int maxAncestorDiff(TreeNode node, int max, int min){
        if(node == null){
            return max - min;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(maxAncestorDiff(node.left, max, min), maxAncestorDiff(node.right, max, min));
    }
}