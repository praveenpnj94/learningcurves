//https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/


/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}
*/
class Tree
{
    public static int isSumProperty(Node node)
    {
        return isSumPropertyUtil(node)?1:0;
    }
    public static boolean isSumPropertyUtil(Node node)
    {
        int sum =0;
        if(node == null || (node.left == null && node.right == null)){
            return true;
        }
        if(node.right!=null){
            sum +=node.right.data;
        }
        if(node.left!=null){
            sum +=node.left.data;
        }       
        return (node.data==sum) && isSumPropertyUtil(node.left) && isSumPropertyUtil(node.right);
    }
}