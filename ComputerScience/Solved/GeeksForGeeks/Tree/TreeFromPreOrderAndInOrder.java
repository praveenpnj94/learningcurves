//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/


/*This is a function problem.You only need to complete the function given below*/
class GfG
{
    public static int preIndex;
    GfG(int ind)
    {
        preIndex = ind;
    }
    
  public static Node buildTree(int in[], int pre[], int st, int end)
    {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
           int idx = 0;
           for(int i :in){
               m.put(i,idx);
               idx++;
           }
           
           if(st>end){
               return null;
           }
           Node node = new Node(pre[preIndex]);
           int index = m.get(node.data);
           preIndex++;
           node.left = buildTree(in,pre,st,index-1);
           node.right = buildTree(in,pre,index+1,end);
           return node;
    }
}