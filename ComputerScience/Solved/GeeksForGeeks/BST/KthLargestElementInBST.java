//https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/


/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
The Node is as follows 
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}
*/
class GfG
{
    static int count = 0;
    public void kthLargest(Node root,int k)
    {
        count =0;
        kthLargestUtil(root,k);
    }
    
    public void kthLargestUtil(Node root,int k)
    {
        if(root==null || count>k){
            return;
        }
        kthLargestUtil(root.right,k);
        count++;
        if(count==k){
            System.out.println(root.data);
            return;
        }
        kthLargestUtil(root.left,k);
    }
}