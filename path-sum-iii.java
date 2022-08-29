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
    public int pathSum(TreeNode root, int targetSum) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return path(root, 0, targetSum, map);
        
    }
    
    private int path(TreeNode node, int sum, int target, Map<Integer, Integer> map){
        if(node == null){
            return 0;
        }
        sum += node.val;
        int res = 0;
        Integer count = map.get(sum - target);
        if(count == null){
            count = 0;
        }
        res += count;
        count = map.get(sum);
        if(count == null){
            count = 0;
        }
        map.put(sum, count + 1);
        
        int left = path(node.left, sum, target, map);
        int right = path(node.right, sum, target, map);
        
        map.put(sum, map.get(sum) - 1);
        return res + left + right;
    }
}