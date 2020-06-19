//https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/

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
    public TreeNode buildTree(int[] A) {
        if(A.length==0){
            return null;
        }
        return util(A,0,A.length-1);
    }
    
    public TreeNode util(int[] A, int l, int h){
        if(l>h){
            return null;
        }
        int mxIdx = find(A,l,h);
        TreeNode root = new TreeNode(A[mxIdx]);
        root.right = util(A,mxIdx+1,h);
        root.left = util(A,l,mxIdx-1);
        return root;
    }
    public int find(int[] A, int l, int h){
        int maxVal = Integer.MIN_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        for(int i=l;i<=h;i++){
            if(A[i]>maxVal){
                maxVal = A[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
