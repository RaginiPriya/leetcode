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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        
        find(root, map, result);
        
        return result;
    }
    
    private String find(TreeNode node, Map<String, Integer> map, List<TreeNode> result){
        
        if(node == null){
            return "N";
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.val).append(",");
        
        sb.append(find(node.left, map, result)).append(",");
        sb.append(find(node.right, map, result)).append(",");
        
        String key = sb.toString();
        
        Integer count = map.get(key);
        
        if(count == null){
            count = 0;
        }
        if(count == 1){
            result.add(node);
        }
        map.put(key, count + 1);
        
        return key;
        
    }
}