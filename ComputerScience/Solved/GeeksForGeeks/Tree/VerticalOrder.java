//https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
//https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}*/
class BinaryTree
{
    static void verticalOrder(Node root)
    {
    //     if(root == null){
	   //     return;
	   // }
	   // TreeMap<Integer,List<Integer>> m = new TreeMap<Integer,List<Integer>>();
	   // int level =0;
	   // int count = 0;
	   // process(root,m,level);
	   // for(Map.Entry<Integer,List<Integer>> entry: m.entrySet()){
	   //     List<Integer> l = entry.getValue();
	   //     for(int i : l){
	   //         System.out.print(i+" ");
	   //     }
	   // }
	    class QueueObj { 
            Node node; 
            int hd; 
  
            QueueObj(Node node, int hd) { 
                this.node = node; 
                this.hd = hd; 
            } 
        } 
        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        Map<Integer, List<Node>> topViewMap = new TreeMap<Integer, List<Node>>(); 
  
        if (root == null) { 
            return; 
        } else { 
            q.add(new QueueObj(root, 0)); 
        } 
          
        // count function returns 1 if the container  
        // contains an element whose key is equivalent  
        // to hd, or returns zero otherwise. 
        while (!q.isEmpty()) { 
            QueueObj tmpNode = q.poll(); 
            if (topViewMap.containsKey(tmpNode.hd)) { 
                List<Node> l = topViewMap.get(tmpNode.hd);
                l.add(tmpNode.node);
                topViewMap.put(tmpNode.hd, l); 
            } 
            else{
                List<Node> l = new ArrayList<Node>();
                l.add(tmpNode.node);
                topViewMap.put(tmpNode.hd, l); 
            }
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
            } 
  
        } 
        for (Map.Entry<Integer,List<Node>> entry : topViewMap.entrySet()) { 
            List<Node> l = entry.getValue();
            for(Node n:l){
                System.out.print(n.data+" ");
            }
        } 
    }
}
