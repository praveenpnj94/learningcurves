//https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node (int d){
		data=d;
		left=right=null;
	}
}
*/
class BST
{
	public void printCommon(Node root1,Node root2)
         {
             LinkedHashSet<Integer> hs1 = new LinkedHashSet<Integer>();
             LinkedHashSet<Integer> hs2 = new LinkedHashSet<Integer>();
             inorder(root1,hs1);
             inorder(root2,hs2);
             int l1 = hs1.size();
             int l2 = hs2.size();
             for(int i:hs1){
                 if(hs2.contains(i)){
                     System.out.print(i+" ");
                 }
             }
         }
    
    public void inorder(Node root,LinkedHashSet<Integer> hs){
        if(root==null){
            return;
        }
        inorder(root.left,hs);
        hs.add(root.data);
        inorder(root.right,hs);
    }
}
