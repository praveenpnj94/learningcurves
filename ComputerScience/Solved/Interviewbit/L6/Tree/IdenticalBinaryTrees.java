//https://www.interviewbit.com/problems/identical-binary-trees/

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
    public int isSameTree(TreeNode A, TreeNode B) {
        if(isSameTreeUtil(A,B)){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public boolean isSameTreeUtil(TreeNode A, TreeNode B) {
        if(A==null && B==null){
            return true;
        }
        else if( A==null||B==null){
            return false;
        }
        else{
            return (A.val==B.val && isSameTreeUtil(A.left,B.left) && isSameTreeUtil(A.right,B.right));
        }
    }
}
