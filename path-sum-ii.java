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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode node, int target, int sum, List<List<Integer>> result, List<Integer> temp){
        if(node == null){
            return;
        }
        sum += node.val;
        temp.add(node.val);
        if(node.left == null && node.right == null && target == sum){
            result.add(new ArrayList<>(temp));
        }

        dfs(node.left, target, sum, result, temp);
        dfs(node.right, target, sum, result, temp);
        
        temp.remove(temp.size() - 1);
    }
}