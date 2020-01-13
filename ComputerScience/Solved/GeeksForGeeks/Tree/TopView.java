//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class View
{
    static void topView(Node root) { 
        class QueueObj { 
            Node node; 
            int hd; 
  
            QueueObj(Node node, int hd) { 
                this.node = node; 
                this.hd = hd; 
            } 
        } 
        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
  
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
            if (!topViewMap.containsKey(tmpNode.hd)) { 
                topViewMap.put(tmpNode.hd, tmpNode.node); 
            } 
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
            } 
  
        } 
        for (Map.Entry<Integer,Node> entry : topViewMap.entrySet()) { 
            System.out.print(entry.getValue().data+" "); 
        } 
    }
    
    // function should print the topView of the binary tree
    static void topView2(Node root)
    {
        TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();
        if(root==null){
            return;
        }
        process(root,m, 0);
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }
    static void process(Node root,TreeMap<Integer,Integer> m,int level){
        if(root == null){
            return;
        }
        if(!m.containsKey(level)){
            m.put(level,root.data);            
        }
        process(root.left,m,level-1);
        process(root.right,m,level+1);
    }
}
