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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        
        dfs(root1, first);
        dfs(root2, second);
        
        if(first.size() != second.size()){
            return false;
        }
        
        for(int i = 0; i < first.size(); i++){
            if(first.get(i) != second.get(i)){
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            list.add(node.val);
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}