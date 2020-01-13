/*This is a function problem.You only need to complete the function given below*/
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
    void inOrder(Node root)
    {
        if (root == null) { return; }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}