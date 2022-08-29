/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder sb){
        if(node == null){
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)){
            return null;
        }
        String[] arr = data.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for(String s : arr){
            queue.add(s);
        }
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(Queue<String> queue, int min, int max){
        if(queue.isEmpty()){
            return null;
        }
        String s = queue.peek();
        int val = Integer.valueOf(s);
        if(val < min || val > max){
            return null;
        }
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserialize(queue, min, val);
        node.right = deserialize(queue, val, max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;