//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//https://www.youtube.com/watch?v=vssbwPkarPQ

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
    private TreeNode prev = null;
    
    // public void flatten(TreeNode root) {
    //     if (root == null)
    //         return;
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }   
            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
    }

class Solution {
    
    private TreeNode flattenTree(TreeNode node) {
        
        // Handle the null scenario
        if (node == null) {
            return null;
        }
            
        // For a leaf node, we simply return the
        // node as is.
        if (node.left == null && node.right == null) {
            return node;
        }
        
        //Recursively flatten the left subtree
        TreeNode leftTail = this.flattenTree(node.left);
        
        // Recursively flatten the right subtree
        TreeNode rightTail = this.flattenTree(node.right);
        
        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore.
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        // We need to return the "rightmost" node after we are
        // done wiring the new connections. 
        return rightTail == null ? leftTail : rightTail;
    }
    
    public void flatten(TreeNode root) {
        
        this.flattenTree(root);
    }
}