//https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/


/*This is a function problem.You only need to complete the function given below*/
/*Complete the Given Function
Node is as follows:
class Tree{
int data;
Tree left,right;
Tree(int d){
	data=d;
	left=null;
	right=null;
}
}*/
class GfG{
    public int toSumTree(Tree node){
                 // Base case 
        if (node == null) 
            return 0; 
   
        // Store the old value 
        int old_val = node.data; 
   
        // Recursively call for left and right subtrees and store the sum 
        // as new value of this node 
        node.data = toSumTree(node.left) + toSumTree(node.right); 
   
        // Return the sum of values of nodes in left and right subtrees 
        // and old_value of this node 
        return node.data + old_val;
    }
}