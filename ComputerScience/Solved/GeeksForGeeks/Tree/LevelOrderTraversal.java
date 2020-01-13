//https://www.geeksforgeeks.org/level-order-tree-traversal/
/*
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Level_order_traversal
{
    //You are required to complete this method
    static void levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()){
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
    }
}