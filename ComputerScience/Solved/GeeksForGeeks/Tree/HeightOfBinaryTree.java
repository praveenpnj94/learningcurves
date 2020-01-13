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
class Tree
{
    int height(Node node) 
    {
         if(node == null){
             return 0;
         }
         return (int)Math.max(height(node.left),height(node.right))+1;
    }   
}
