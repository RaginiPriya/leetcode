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
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sumNumbers(root, list, 0);
        int sum = 0;
        for(int num : list){
            sum += num;
        }
        return sum;
    }
    
    private void sumNumbers(TreeNode node, List<Integer> list, int num){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            num = num * 10 + node.val;
            list.add(num);
            return;
        }
        num = num * 10 + node.val;
        sumNumbers(node.left, list, num);
        sumNumbers(node.right, list, num);
    }
}