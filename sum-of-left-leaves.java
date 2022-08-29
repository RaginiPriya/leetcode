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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return 0;
        }
        
        int sum = 0;
        
        if(root.left != null){
            if(root.left.left != null || root.left.right != null){
                sum += sumOfLeftLeaves(root.left);
            }
            else{
                sum += root.left.val;
            }
        }
        
        if(root.right != null && (root.right.left != null || root.right.right != null)){
            sum += sumOfLeftLeaves(root.right);
        }
        
        return sum;
        
        
//         Queue<TreeNode> queue = new ArrayDeque<>();
//         int sum = 0;
//         if(root == null){
//             return sum;
//         }
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i = 0; i < size; i++){
//                 TreeNode node = queue.poll();
//                 if(i == 0){
//                     if(node.left == null && node.right == null){
//                         sum += node.val;
//                     }
//                 }
//                 if(node.left != null){
//                     queue.add(node.left);
//                 }
//                 if(node.right != null){
//                     queue.add(node.right);
//                 }
//             }
//         }
        
//         return sum;
    }
}