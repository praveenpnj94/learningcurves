//https://leetcode.com/problems/closest-binary-search-tree-value/

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
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return 0;
        }
        int val;
        int closest = root.val;
        while(root!=null){
            val = root.val;
            closest = Math.abs(val-target) < Math.abs(closest-target)?val :closest;
            root = target<val?root.left:root.right;
        }
        return closest;
    }
}

class Solution {
    public void inorder(TreeNode root, List<Integer> nums) {
      if (root == null) return;
      inorder(root.left, nums);
      nums.add(root.val);
      inorder(root.right, nums);
    }
  
    public int closestValue(TreeNode root, double target) {
      List<Integer> nums = new ArrayList();
      inorder(root, nums);
      return Collections.min(nums, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
        }
      });
    }
  }