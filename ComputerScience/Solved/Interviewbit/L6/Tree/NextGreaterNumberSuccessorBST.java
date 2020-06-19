//https://www.interviewbit.com/problems/next-greater-number-bst/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode getSuccessor(TreeNode root, int p) {
        // if (root == null)
        //     return null;

        // if (root.val <= p) {
        //     return getSuccessor(root.right, p);
        // } else {
        //     TreeNode left = getSuccessor(root.left, p);
        //     return (left != null) ? left : root;
        // }
        TreeNode res =null;
        while(root!=null){
            if(root.val>p){
                res = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return res;
    }
}