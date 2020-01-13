
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}*/
class GfG
{
      static int minDiff = Integer.MAX_VALUE;
      public static int maxDiff(Node root, int k)
      {
           minDiff = Integer.MAX_VALUE;
           if(root==null){
               return 0;
           }
           inorder(root,k);
           return minDiff;
      }
       
      public static void inorder(Node root,int k){
          if(root==null){
              return;
          }
          inorder(root.left,k);
          minDiff = Math.min(minDiff,Math.abs(root.data-k));
          inorder(root.right,k);
      }
}