/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Tree
{
    void postOrder(Node root)
    {
        if (root == null) { return; }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}