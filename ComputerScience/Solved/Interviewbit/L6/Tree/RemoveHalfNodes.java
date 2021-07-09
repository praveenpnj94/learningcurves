//https://www.interviewbit.com/problems/remove-half-nodes/
//https://www.geeksforgeeks.org/given-a-binary-tree-how-do-you-remove-all-the-half-nodes/
//https://www.youtube.com/watch?v=VW0ia_uBN0o

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode solve(TreeNode node) {
        if (node == null) 
            return null; 
   
        node.left = solve(node.left); 
        node.right = solve(node.right); 
   
        if (node.left == null && node.right == null) 
            return node; 
   
        /* if current nodes is a half node with left 
         child NULL left, then it's right child is 
         returned and replaces it in the given tree */
        if (node.left == null)  
        { 
            TreeNode new_root = node.right; 
            return new_root; 
        } 
   
        /* if current nodes is a half node with right 
           child NULL right, then it's right child is 
           returned and replaces it in the given tree  */
        if (node.right == null)  
        { 
            TreeNode new_root = node.left; 
            return new_root; 
        } 
   
        return node;
    }
}
