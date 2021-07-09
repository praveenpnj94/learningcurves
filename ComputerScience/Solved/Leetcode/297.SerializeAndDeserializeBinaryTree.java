//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//https://www.youtube.com/watch?v=plddsldeckc&ab_channel=ShreyaKarmakar

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
        if(root==null){
            return null;
        }        
        StringBuilder sb = new StringBuilder();
        shelper(root,sb);
        return sb.toString();
    }
    
    public void shelper(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("X").append(",");
        }
        else{
            sb.append(root.val).append(",");
            shelper(root.left,sb);
            shelper(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return dhelper(q);
    }
    
    public TreeNode dhelper(Queue<String> q){
        TreeNode root = null;
        String temp = q.poll();
        if(temp.equals("X")){
            return null;
        }        
        root = new TreeNode(Integer.parseInt(temp));
        root.left = dhelper(q);
        root.right = dhelper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));