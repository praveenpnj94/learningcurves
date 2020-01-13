//https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
//https://www.geeksforgeeks.org/connect-nodes-at-same-level/


/*class Node
{
    int data;
    Node left, right, nextRight;
    Node(int x)
    {
        this.data = x;
        left = right = nextRight = null;
    }
    
    
}*/
class Level
{
    static void connect(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node p = q.peek();
                q.remove();
                if(i==size-1){
                    p.nextRight = null; 
                }
                else{
                    p.nextRight = q.peek();
                }
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
        }
    }
    
    
}
