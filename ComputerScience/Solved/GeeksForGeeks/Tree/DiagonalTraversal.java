//https://www.youtube.com/watch?v=e9ZGxH1y_PE
//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/


/*This is a function problem.You only need to complete the function given below*/
/* Node is defined as
class TreeNode
{
    int data; //node data
    TreeNode left, right; //left and right child's reference
    // Tree node constructor
    public TreeNode(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/
class GfG
{
     TreeMap<Integer,List<Integer>> map = null;
     public void diagonalPrint(TreeNode root)
      {
           map = new TreeMap<Integer,List<Integer>>();
           int level =0;
           inorder(root,map,level);
           for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
               List<Integer> l = entry.getValue();
               for(int num:l){
                   System.out.print(num+" ");
               }
           }
      }
      
      public void inorder(TreeNode root,TreeMap<Integer,List<Integer>> map, int level){
          if(root == null){
              return;
          }
          inorder(root.left,map,level+1);
          List<Integer> l = null;
          if(map.containsKey(level)){
              l = map.get(level);
          }
          else{
              l= new ArrayList<Integer>();
          }
          l.add(root.data);
          map.put(level,l);
          inorder(root.right,map,level);
      }
}