//https://www.interviewbit.com/problems/balanced-binary-tree/

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
    public int isBalanced(TreeNode A) {
        if(A==null){
            return 1;
        }
        int lheight = height(A.left);
        int rheight = height(A.right);
        if(Math.abs(lheight-rheight)<=1 && isBalanced(A.left)==1 && isBalanced(A.right)==1){
            return 1;
        }
        return 0;
    }
    
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
}
