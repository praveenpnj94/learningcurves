//https://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*
class Node {
    int data;
    Node left, right;
    Node(int key){
        this.data = key;
        this.left = this.right = null;
    }
}
*/
class GfG {
    int findCeil(Node root, int key) { 
        if (root == null)
            return -1;
        /* If root->data is equal to key */
        if (root.data == key) 
            return root.data; 
  
        if (root.data < key) 
            return findCeil(root.right, key); 
            
        else{
            int ceilValue = findCeil(root.left, key); 
            return (ceilValue >= key) ? ceilValue : root.data;            
        }

    } 
}

