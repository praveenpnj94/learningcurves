//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean order = true;

    while(!q.isEmpty()) {
        List<Integer> tmp = new ArrayList<>();
        int size = q.size();
        for(int i = 0; i < size; ++i) {
            TreeNode n = q.poll();
            if(order) {
                tmp.add(n.val);
            } else {
                tmp.add(0, n.val);
            }
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
        }
        res.add(tmp);
        order = !order;
    }
    return res;
        
    }
}