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
    
    //              1
    //          2       3
    //                      4
    //                          5
    public boolean isCousins(TreeNode root, int x, int y) {
        
        // Map<Integer, TreeNode> parentMap = new HashMap<>();
        
        // parentMap.put(root.val, null);
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        int level = 0;
        
        int xLevel = -1;
        int yLevel = -1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val == x){
                    xLevel = level;
                }
                else if(node.val == y){
                    yLevel = level;
                }
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y){
                        return false;
                    }
                    if(node.left.val == y && node.right.val == x){
                        return false;
                    }
                }
                if(xLevel >= 0 && yLevel >= 0){
                    if(xLevel == yLevel){
                        // TreeNode xParent = parentMap.get(x);
                        // TreeNode yParent = parentMap.get(y);
                        // if(xParent == yParent){
                            // return false;
                        // }
                        return true;
                    }
                }

                if(node.left != null){
                    // parentMap.put(node.left.val, node);
                    queue.add(node.left);
                }
                if(node.right != null){
                    // parentMap.put(node.right.val, node);
                    queue.add(node.right);
                }
            }
            level++;
        }
        
        return false;
        
    }
}