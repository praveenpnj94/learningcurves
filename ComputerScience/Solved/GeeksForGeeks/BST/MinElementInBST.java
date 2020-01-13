//https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/

/*This is a function problem.You only need to complete the function given below*/
/* A binary search tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}
*/
// your task is to complete the below function
class BST
{
    int minValue(Node node)
    {
        if(node == null){
            return -1;
        }
        int minVal = Integer.MAX_VALUE;
        while(node!=null){
            minVal = Math.min(minVal,node.data);
            node = node.left;
        }
        return minVal;
    }
}
