//https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if(A==null){
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        boolean rev = false;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<size;i++){
               TreeNode tn = q.poll();
               al.add(tn.val);
               if(tn.left!=null){
                   q.add(tn.left);
               }
               if(tn.right!=null){
                   q.add(tn.right);
               }
            }
            if(rev){
                Collections.reverse(al);
            }
            res.add(al);
            rev=!rev;
        }
        return res;
    }
}
