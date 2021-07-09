//https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        return validBstUtil(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean validBstUtil(TreeNode root, long minVal, long maxVal){
        if(root==null){
            return true;
        }
        return (root.val>minVal && root.val<maxVal) && validBstUtil(root.left,minVal,root.val)
&& validBstUtil(root.right,root.val,maxVal);
    }
}