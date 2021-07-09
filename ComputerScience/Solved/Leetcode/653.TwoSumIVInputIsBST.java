//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        inorder(root);
        int l=0;
        int r=list.size()-1;
        if(r<0){
            return false;
        }
        while(l<r){
            int sum = list.get(l)+list.get(r);
            if(sum==k){
                return true;
            }
            else if(sum<k){
                l++;
            }
            else{
                r--;
            }
            
        }
        return false;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    
}