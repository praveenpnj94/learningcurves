//https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/


/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class GfG
{
     // Recursive function to print right view of a binary tree.
     void printKdistance(Node root, int k)
     {
          if(root==null){
              return;
          }
          if(k==0){
              System.out.print(root.data+" ");
              return;
          }
          printKdistance(root.left,k-1);
          printKdistance(root.right,k-1);
     }
}