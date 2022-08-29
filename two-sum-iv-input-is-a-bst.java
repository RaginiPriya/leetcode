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
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        
        inorder(list, root);
        
        int left = 0;
        int right = list.size() - 1;
        
        while(left < right){
            int sum = list.get(left) + list.get(right);
            if(sum == k){
                return true;
            }
            if(sum < k){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
    
    private void inorder(List<Integer> list, TreeNode node){
        if(node == null){
            return;
        }
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }
    
    
}