//https://www.geeksforgeeks.org/reverse-level-order-traversal/

/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
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
class GfG
{
void reversePrint(Node node) 
    {
        Stack<Node> S = new Stack<>();
        Queue<Node> Q = new LinkedList<>(); 
        Q.add(node); 
        while(Q.isEmpty() == false){
            Node p = Q.peek(); 
            Q.remove(); 
            S.push(p); 
            if(p.right!=null){
                Q.add(p.right);
            }
            if(p.left!=null){
                Q.add(p.left);
            }
        }
        while(!S.isEmpty()){
            System.out.print(S.pop().data+" ");
        }
    }
}      
       
