//https://leetcode.com/problems/path-sum/

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return hasPathSumUtil(root,sum);
        
    }
    
    public boolean hasPathSumUtil(TreeNode A, int B) {
        if(A==null){
            return false;
        }
        if(A.val==B && A.left==null && A.right==null){
            return true;
        }
        return hasPathSumUtil(A.left,B-A.val)||hasPathSumUtil(A.right,B-A.val);
    }
}