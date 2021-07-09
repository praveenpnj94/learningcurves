//https://www.interviewbit.com/problems/reverse-level-order/

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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A==null){
            return res;
        }
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tn = q.poll();
                temp.add(tn.val);
                if(tn.left!=null){
                    q.add(tn.left);
                }
                if(tn.right!=null){
                    q.add(tn.right);
                }
            }
            al.add(temp);
        }
        for(int i=al.size()-1;i>=0;i--){
            ArrayList<Integer> help = al.get(i);
            res.addAll(help);
        }
        return res;
    }
}
