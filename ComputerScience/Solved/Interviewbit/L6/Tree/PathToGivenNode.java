//https://www.interviewbit.com/problems/path-to-given-node/
//https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/

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
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A==null){
            return res;
        }
        hasPath(A,res,B);
        return res;
    }
    
    public boolean hasPath(TreeNode root,ArrayList<Integer> res,int B){
        if(root==null){
            return false;
        }
        res.add(root.val);
        
        if(root.val==B){
            return true;
        }
        
        if(hasPath(root.left,res,B)||hasPath(root.right,res,B)){
            return true;
        }
        
        res.remove(res.size()-1);
        return false;
    }
}
