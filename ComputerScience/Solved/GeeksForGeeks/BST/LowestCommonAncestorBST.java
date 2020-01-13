//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

/*This is a function problem.You only need to complete the function given below*/
/* A Binary Search Tree node */
/* class Node
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
    Node LCA(Node node, int n1, int n2) 
    {
        if(node == null){
            return null;
        }
        if(node.data> n1 && node.data>n2){
            return LCA(node.left,n1,n2);
        }
        if(node.data< n1 && node.data<n2){
            return LCA(node.right,n1,n2);
        }
        return node;
    }
    
}
