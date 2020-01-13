//https://www.geeksforgeeks.org/print-left-view-binary-tree/

/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    void leftView(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp;
               if(i==0){
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
