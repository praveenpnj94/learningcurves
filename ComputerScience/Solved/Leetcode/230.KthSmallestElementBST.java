//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         ArrayList<Integer> al = new ArrayList<>();
//         inorder(root,al);
//         return al.get(k-1);
//     }
//     void inorder(TreeNode root, ArrayList<Integer> al){
//         if(root==null){
//             return;
//         }
//         inorder(root.left,al);
//         al.add(root.val);
//         inorder(root.right,al);
//     }
// }

class Solution {
    public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
  
      while (true) {
        while (root != null) {
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        if (--k == 0) return root.val;
        root = root.right;
      }
    }
  }