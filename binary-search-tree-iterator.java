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
class BSTIterator {
    
    // int[] inorder;
    // int pointer = 0;
    
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {        
        // List<Integer> list = new ArrayList<>();
        // inorder(root, list);
        // inorder = new int[list.size()];
        // for(int i = 0; i < inorder.length; i++){
        //     inorder[i] = list.get(i);
        // }        
        pushAll(root);
    }
    
    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    // private void inorder(TreeNode node, List<Integer> list){
    //     if(node == null){
    //         return;
    //     }
    //     inorder(node.left, list);
    //     list.add(node.val);
    //     inorder(node.right, list);
    // }
    
    public int next() {
        // return inorder[pointer++];
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
        // return pointer < inorder.length;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */