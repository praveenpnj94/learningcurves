//https://www.interviewbit.com/problems/2sum-binary-tree/
/*
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
    public int t2Sum(TreeNode A, int B) {
        if(A==null){
            return 0;
        }
        ArrayList<Integer> al = new ArrayList<>();
        inorder(A,al);
        int l=0;
        int h= al.size()-1;
        while(l<h){
            int sum = al.get(l)+al.get(h);
            if(sum==B){
                return 1;
            }
            else if(sum>B){
                h--;
            }
            else{
                l++;
            }
        }
        return 0;
    }
    
    public void inorder(TreeNode root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }
}