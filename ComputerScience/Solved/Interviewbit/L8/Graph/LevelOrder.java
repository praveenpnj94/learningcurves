//https://www.interviewbit.com/problems/level-order/

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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> l = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode p = q.poll();
                l.add(p.val);
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
            al.add(l);
        }
        return al;
    }
}
