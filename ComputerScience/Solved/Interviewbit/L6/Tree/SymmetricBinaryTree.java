//https://www.interviewbit.com/problems/symmetric-binary-tree/

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
    public int isSymmetric(TreeNode A) {
        if(isSymmetricUtil(A,A)){
            return 1;
        }
        else{
            return 0;
        }
    }
    public boolean isSymmetricUtil(TreeNode A, TreeNode B) {
        if(A==null && B== null){
            return true;
        }
        if(A!=null && B!=null && A.val == B.val){
            return isSymmetricUtil(A.left,B.right) 
                    && isSymmetricUtil(A.right,B.left);
        }
        return false;
    }
}