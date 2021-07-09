//https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/

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
    public int sumNumbers(TreeNode A) {
        return util(A,0);
    }
    
    public int util(TreeNode A, int val){
        
        if(A==null){
            return 0;
        }
        val=(val*10+A.val)%1003;
        if(A.left==null && A.right == null){
            return val;
        }
        return (util(A.left,val)+util(A.right,val))%1003;
    }
}
