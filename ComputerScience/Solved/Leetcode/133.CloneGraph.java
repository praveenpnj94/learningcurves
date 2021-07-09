//https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// class Solution {
//     public HashMap<Integer, Node> map = new HashMap<>();
    
//     // public Node cloneGraph(Node node) {
//     //     return clone(node);
//     // }
    
//     public Node cloneGraph(Node node) {
//         if (node == null) return null;
        
//         if (map.containsKey(node.val)) 
//             return map.get(node.val);
        
//         Node newNode = new Node(node.val, new ArrayList<Node>());
//         map.put(newNode.val, newNode);
//         for (Node neighbor : node.neighbors) 
//             newNode.neighbors.add(cloneGraph(neighbor));
//         return newNode;
//     }
// }


class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Queue<Node> q = new LinkedList();
        Map<Integer, Node> visited =new HashMap<>();
        q.add(node);
        Node res = new Node(node.val);
        visited.put(node.val, res);
        while(!q.isEmpty()){
            Node curr = q.poll();
            // System.out.println("curr = "+ curr.val);
            List<Node> neighbors = curr.neighbors;
            for(Node n: neighbors){
                if(!visited.containsKey(n.val)){
                    q.add(n);
                    visited.put(n.val, new Node(n.val));
                }
                List<Node> newNeighbours = visited.get(curr.val).neighbors;
                newNeighbours.add(visited.get(n.val));
            }
        }
        
        return res;
    }
}