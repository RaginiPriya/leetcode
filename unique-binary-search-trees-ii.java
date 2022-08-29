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
    public List<TreeNode> generateTrees(int n) {
        
        return generate(1, n);
        
    }
    
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        
        if(start > end){
            list.add(null);
            return list;
        }
        
        for(int i = start; i <= end; i++){
            
            List<TreeNode> lefts = generate(start, i - 1);
            List<TreeNode> rights = generate(i + 1, end);
            
            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        
        return list;
    }
}