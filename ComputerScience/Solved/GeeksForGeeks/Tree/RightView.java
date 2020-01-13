//https://www.geeksforgeeks.org/print-right-view-binary-tree-2/

/*This is a function problem.You only need to complete the function given below*/
/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/
class Tree{
    void rightView(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp;
               if(i==size-1){
                   temp = q.poll();
                   System.out.print(temp.data+" ");
               }
               else{
                   temp = q.poll();
               }
               if(temp.left!=null){
                   q.add(temp.left);
               }
               if(temp.right!=null){
                   q.add(temp.right);
               }
            }
        }
    }
}
