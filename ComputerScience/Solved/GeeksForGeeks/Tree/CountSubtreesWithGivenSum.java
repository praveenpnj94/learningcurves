//https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
// Return the count of the sub-trees having sum as X.
class GFG
{
    static class INT 
{ 
    int v; 
    INT(int a) 
    { 
        v = a; 
    } 
}
    int countSubtreesWithSumX(Node root, int x)
    {
	       // if tree is empty  
    if (root == null)  
        return 0;  
  
    INT count = new INT(0);  
  
    // sum of nodes in the left subtree  
    int ls = countSubtreesWithSumXRecur(root.left, 
                                   count, x);  
  
    // sum of nodes in the right subtree  
    int rs = countSubtreesWithSumXRecur(root.right,  
                                   count, x);  
  
    // if tree's nodes sum == x  
    if ((ls + rs + root.data) == x)  
        count.v++;  
  
    // required count of subtrees  
    return count.v; 
    }
    int countSubtreesWithSumXRecur(Node root,  
                          INT count, int x)  
{  
    // if tree is empty  
    if (root == null)  
        return 0;  
  
    // sum of nodes in the left subtree  
    int ls = countSubtreesWithSumXRecur(root.left,  
                                   count, x);  
  
    // sum of nodes in the right subtree  
    int rs = countSubtreesWithSumXRecur(root.right,  
                                   count, x);  
  
    // sum of nodes in the subtree  
    // rooted with 'root.data'  
    int sum = ls + rs + root.data;  
  
    // if true  
    if (sum == x)  
        count.v++;  
  
    // return subtree's nodes sum  
    return sum;  
}
}

