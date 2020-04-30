//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
//https://www.youtube.com/watch?v=Mu4b6dLfCks
//https://www.youtube.com/watch?v=_Es-FEkjKmA
//https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/

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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        int n = arr.length;
        int pos = 0;
        return isValidSequenceUtil(root,arr,n,0);
    }
    
    public boolean isValidSequenceUtil(TreeNode root, int[] arr, int n, int pos) {
        if(root == null && n>0){
            return false;
        }
        else if(pos==n){
            return false;
        }
        else if(root.val!=arr[pos]){
            return false;
        }
        else if( root.left ==null && root.right ==null && pos==n-1){
            return true;
        }
        return (isValidSequenceUtil(root.left,arr,n,pos+1)||isValidSequenceUtil(root.right,arr,n,pos+1));
        
    }
}