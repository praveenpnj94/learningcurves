//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair {
        int val;
        int layer;
        Pair(int val, int layer) {
            this.val = val;
            this.layer = layer;
        }
    }
    
    // time: O(n lg (n/k)), n # of nodes in tree, k # of cols, partition sort by col groups
    // space:  O(n) + O(lgn) for dfs call stack, 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>(); // key = col
        dfs(root, map, 0, 0);

        List<List<Integer>> results = new ArrayList<>();
        for (int i: map.keySet()) {
            List<Pair> list = map.get(i);
            Collections.sort(list, (a,b) -> (a.layer == b.layer) ? a.val - b.val : a.layer - b.layer);
            List<Integer> result = new ArrayList<>();
            for (Pair p: list) result.add(p.val);
            results.add(result);
        }
        return results;
    }
    
    private void dfs(TreeNode root, Map<Integer, List<Pair>> map, int col, int layer) {
        if (root == null) return;

        map.putIfAbsent(col, new ArrayList<>());
        List<Pair> list = map.get(col);
        list.add(new Pair(root.val, layer));
        
        dfs(root.left, map, col-1, layer+1);
        dfs(root.right, map, col+1, layer+1);
    }
}