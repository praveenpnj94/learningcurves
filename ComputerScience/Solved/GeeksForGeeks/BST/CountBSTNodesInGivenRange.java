//https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/

/*This is a function problem.You only need to complete the function given below*/
// A Binary Search Tree node
/*
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
*/
//Complete this function
public static int getCountOfNode(Node root,int l, int h)
{

    if(root==null){
        return 0;
    }
    Count cnt = new Count();
    return util(root,l,h,cnt);
}

public static int util(Node root,int l, int h,Count cnt){
    if(root==null){
        return 0;
    }
    util(root.left,l,h,cnt);
    if(root.data>=l && root.data<=h){
        cnt.val++;
    }
    util(root.right,l,h,cnt);
    return cnt.val;
}

    // Returns count of nodes in BST in  
    // range [low, high] 
    int getCount(Node node, int low, int high) 
    { 
        // Base Case 
        if(node == null) 
            return 0; 
  
        // If current node is in range, then  
        // include it in count and recur for  
        // left and right children of it 
        if(node.data >= low && node.data <= high) 
            return 1 + this.getCount(node.left, low, high)+ 
                this.getCount(node.right, low, high); 
                  
        // If current node is smaller than low,  
        // then recur for right child 
        else if(node.data < low) 
            return this.getCount(node.right, low, high); 
          
        // Else recur for left child 
        else
            return this.getCount(node.left, low, high);      
    }
static class Count{
    int val =0;
}
