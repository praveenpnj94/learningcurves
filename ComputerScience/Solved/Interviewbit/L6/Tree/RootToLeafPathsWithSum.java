//https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/

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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        util(A,B,curr,res);
        return res;
    }
    
    public void util(TreeNode A, int B, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        
        if(A==null){
            return;
        }
        curr.add(A.val);
        if(A.left==null && A.right == null && A.val==B){
            res.add(new ArrayList<>(curr));
        }
        else{
            util(A.left,B-A.val,curr,res);
            util(A.right,B-A.val,curr,res);
        }
        
        curr.remove(curr.size()-1);
    }
}
