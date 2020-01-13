//https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/


/*This is a function problem.You only need to complete the function given below*/
/* Structure of BST node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class BST
{
    /* This function should insert a new node with given data and
      return root of the modified tree  */
    Node insert(Node root, int data)
    {
        if(root==null){
            return new Node(data);
        }
        if(root.data>data){
            root.left = insert(root.left,data);
        }
        if(root.data<data){
            root.right = insert(root.right,data);
        }
        return root;
    }
}
