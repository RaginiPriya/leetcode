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
    public int widthOfBinaryTree(TreeNode root) {
        
        Map<TreeNode, Integer> indexMap = new HashMap<>();
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.add(root);
        indexMap.put(root, 1);
        
        int max = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            int start = 0;
            int end = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                int index = indexMap.get(node);
                if(i == 0){
                    start = index;
                }
                if(i == size - 1){
                    end = index;
                }
                if(node.left != null){
                    queue.add(node.left);
                    indexMap.put(node.left, 2 * index);
                }
                if(node.right != null){
                    queue.add(node.right);
                    indexMap.put(node.right, 2 * index + 1);
                }
            }
            
            max = Math.max(max, end - start + 1);
            
        }
        return max;
        
    }
}