//https://leetcode.com/problems/merge-two-binary-trees/

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
    public TreeNode mergeTrees(TreeNode A, TreeNode B) {
        if(A==null && B==null){
            return null;
        }
        if(A==null && B!=null){
            return B;
        }
        if(A!=null && B==null){
            return A;
        }
        int val = A.val+B.val;
        TreeNode r = new TreeNode(val);
        r.left = mergeTrees(A.left,B.left);
        r.right = mergeTrees(A.right,B.right);
        return r;
    }
}