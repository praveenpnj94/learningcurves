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
class Level_Order_Traverse
{
    static void levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
            Node p = q.peek();
            q.remove();
            System.out.print(p.data+" ");
            if(p.left!=null){
                q.add(p.left);
            }
            if(p.right!=null){
                q.add(p.right);
            }
            }
            System.out.print("$ ");
        }
    }
}