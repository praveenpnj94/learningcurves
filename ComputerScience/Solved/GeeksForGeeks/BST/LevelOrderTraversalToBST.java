//https://www.geeksforgeeks.org/construct-bst-given-level-order-traversal/

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*
The structure of the Node is as follows:
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class GFG {
    
    static Node node = null;
    public Node constructBST(int[] arr){
        node = null;
        node = constructBSTUtil(arr);
        return node;
    }
    
    public Node constructBSTUtil(int[] arr){
        node = null;
        for(int i:arr){
            node = insertNode(node,i);
        }
        return node;
    }
    
    public Node insertNode(Node node,int key){
        if(node == null){
            return new Node(key);
        }
        if(node.data>key){
            node.left = insertNode(node.left,key);
        }
        else if(node.data<key){
            node.right = insertNode(node.right,key);
        }
        return node;
    }
}