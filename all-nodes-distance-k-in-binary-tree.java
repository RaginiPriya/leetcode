/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        dfs(root, nodeToParent, null);
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        
        int level = 0;
        List<Integer> result = new ArrayList<>();
        
        while(!queue.isEmpty()){
            if(level == k){
                while(!queue.isEmpty()){
                    result.add(queue.poll().val);
                }
                return result;
            }
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                visited.add(node);
                if(node.left != null && !visited.contains(node.left)){
                    queue.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    queue.add(node.right);
                }
                TreeNode parent = nodeToParent.get(node);
                if(parent != null && !visited.contains(parent)){
                    queue.add(parent);
                }
            }
            level++;
        }
        
        return result;
        
    }
    
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> nodeToParent, TreeNode parent){
        if(node == null){
            return;
        }
        nodeToParent.put(node, parent);
        dfs(node.left, nodeToParent, node);
        dfs(node.right, nodeToParent, node);
    }
}