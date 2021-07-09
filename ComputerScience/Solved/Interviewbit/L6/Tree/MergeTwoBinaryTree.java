//https://www.interviewbit.com/problems/merge-two-binary-tree/

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
    public TreeNode solve(TreeNode A, TreeNode B) {
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
        r.left = solve(A.left,B.left);
        r.right = solve(A.right,B.right);
        return r;
    }
}
