//https://www.interviewbit.com/problems/maximum-level-sum/

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
    public int solve(TreeNode A) {
        if(A==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int maxSum=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int sum=0;
            int size = q.size();
            for(int i=0;i<size;i++){
               TreeNode tn = q.poll();
               sum+=tn.val;
               if(tn.left!=null){
                   q.add(tn.left);
               }
               if(tn.right!=null){
                   q.add(tn.right);
               }
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
