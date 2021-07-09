//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] A) {
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