//https://www.interviewbit.com/problems/least-common-ancestor/

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
    public int lca(TreeNode A, int B, int C) {
        TreeNode res = lcaUtil(A,B,C);
        if(res!=null){
            return res.val;
        }
        return -1;
    }
    
    public TreeNode lcaUtil(TreeNode A, int B, int C) {
        if(A==null){
            return null;
        }
        if(A.val==B||A.val==C){
            return A;
        }
        TreeNode left = lcaUtil(A.left,B,C);
        TreeNode right = lcaUtil(A.right,B,C);
        if(left!=null && right!=null){
            return A;
        }
        return left==null?right:left;
    }
}
