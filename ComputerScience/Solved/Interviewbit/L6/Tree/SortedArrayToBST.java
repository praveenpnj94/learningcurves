//https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/

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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        if(A.length==0){
            return null;
        }
        int n = A.length;
        return util(A,0,n-1);
    }
    
    public TreeNode util(int[] A, int l, int h){
        if(l>h){
            return null;
        }
        int mid = l+(h-l)/2;
        int el = A[mid];
        TreeNode root = new TreeNode(el);
        root.left = util(A,l,mid-1);
        root.right = util(A,mid+1,h);
        return root;
    }
}
