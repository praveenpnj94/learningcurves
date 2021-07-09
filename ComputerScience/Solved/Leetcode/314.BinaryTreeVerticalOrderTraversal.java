//https://leetcode.com/problems/binary-tree-vertical-order-traversal/

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
    Map<Integer,List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null){
            return Collections.EMPTY_LIST;
        }
        map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0));
        while(!q.isEmpty()){
            Node temp = q.poll();
            TreeNode tn = temp.tn;
            int hd = temp.hd;
            List<Integer> al = null;
            if(map.containsKey(hd)){
                al = map.get(hd);
            }
            else{
                al = new ArrayList<>();     
            }
            al.add(tn.val);
            map.put(hd,al);
            if(tn.left!=null){
                q.add(new Node(tn.left,hd-1));
            }
            if(tn.right!=null){
                q.add(new Node(tn.right,hd+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
class Node{
    TreeNode tn;
    int hd;
    Node(TreeNode tn, int hd){
        this.tn = tn;
        this.hd = hd;
    }
}