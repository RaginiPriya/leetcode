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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : to_delete){
            set.add(num);
        }
        TreeNode node = dfs(result, root, set);
        if(node != null){
            result.add(node);
        }
        return result;
        
    }
    
    private TreeNode dfs(List<TreeNode> result, TreeNode node, Set<Integer> set){
        if(node == null){
            return null;
        }
        node.left = dfs(result, node.left, set);
        node.right = dfs(result, node.right, set);
        
        if(set.contains(node.val)){
            if(node.left != null){
                result.add(node.left);
            }
            if(node.right != null){
                result.add(node.right);
            }
            return null;
        }
        return node;
        
    }
}