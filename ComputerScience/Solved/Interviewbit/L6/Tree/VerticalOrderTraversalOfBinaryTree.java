//https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/

public class Solution {
    
    /**
     * Definition for Node.
     * To store the distances for a given TreeNode.
     **/
    class Node {
        TreeNode node;
        int hd;
        Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        /**
         * Initialize an empty ArrayList
         * and return if A is null.
         **/
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A==null) return result;
        
        /**
         * Initialize a queue to traverse
         * each child node for a subtree
         * and also a HashMap which will
         * store the node values for a 
         * given vertical distance.
         **/
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> Map = new HashMap<>();
        
        /**
         * min and max distances for traversing
         * the HashMap in the end.
         **/
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;
        
        /**
         * Enqueue the root node with 0 distance value.
         * Traverse for all nodes till the queue is empty.
         **/
        q.offer(new Node(A, 0));
        while(!q.isEmpty()) {
            /**
             * Get the top node and add to the HashMap
             * based on the distance value. Also keep
             * upgrading the min and max distances.
             **/
            Node p = q.poll();
            Map.putIfAbsent(p.hd, new ArrayList<Integer>());
            Map.get(p.hd).add(p.node.val);
            minHd = Math.min(minHd, p.hd);
            maxHd = Math.max(maxHd, p.hd);
            
            /**
             * Check if left and right nodes exists for
             * a given node and enqueue them by updating
             * the distance values.
             **/
            if(p.node.left!=null)
                q.offer(new Node(p.node.left, p.hd-1));
            
            if(p.node.right!=null)
                q.offer(new Node(p.node.right, p.hd+1));
        }
        
        /**
         * Traverse HashMap in the end and add all
         * the ArrayLists to result ArrayList and return.
         **/
        for(int i=minHd; i<=maxHd; i++)
            result.add(Map.get(i));
        
        return result;
    }
}