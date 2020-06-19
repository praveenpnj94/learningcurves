//https://www.interviewbit.com/problems/clone-graph/
//https://www.youtube.com/watch?v=e5tNvT1iUXs

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public HashMap<Integer, UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) 
            return map.get(node.label);
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(cloned.label, cloned);
        for(UndirectedGraphNode neighbor: node.neighbors){
            cloned.neighbors.add(cloneGraph(neighbor));
        }
        return cloned;
    }
}
