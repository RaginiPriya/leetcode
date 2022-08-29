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

//          0                                   60
//              59                          17      74
//            57    90                  6     20   63   97
//                                                     95

// 0
// 60 17 6

//

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        
        TreeNode curr1 = root1;
        TreeNode curr2 = root2;
        
        while(curr1 != null || curr2 != null || !first.isEmpty() || !second.isEmpty()){
            while(curr1 != null){
                first.push(curr1);
                curr1 = curr1.left;
            }
        
            while(curr2 != null){
                second.push(curr2);
                curr2 = curr2.left;
            }
            
            if(first.isEmpty() || (!second.isEmpty() && first.peek().val > second.peek().val)){
                TreeNode node = second.pop();
                res.add(node.val);
                if(node.right != null){
                    curr2 = node.right;
                }
            }
            else{
                TreeNode node = first.pop();
                res.add(node.val);
                if(node.right != null){
                    curr1 = node.right;
                }
            }
              
            
        }
        
        return res;
        
    }
    
    
}