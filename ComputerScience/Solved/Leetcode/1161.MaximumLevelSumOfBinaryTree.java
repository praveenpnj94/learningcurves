//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                sum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(sum>maxSum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}

class Solution {
    int n = 10000;
    int[] levelSum = new int[n];
  
    public void inorder(TreeNode node, int level) {
      if (node != null) {
        inorder(node.left, level + 1);
        levelSum[level] += node.val;
        inorder(node.right, level + 1);
      }
    }
    
    public int maxLevelSum(TreeNode root) {
      inorder(root, 1);
  
      int maxIdx = 0;
      for (int i = 0; i < n; ++i)
        maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
      return maxIdx;
    }
}