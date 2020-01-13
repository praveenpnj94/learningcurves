/*This is a function problem.You only need to complete the function given below*/
/* Tree node class
class Node {
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}*/
class Tree
{
    // Should print bottom view of tree with given root
    public void bottomView(Node root)
    {
        TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();
        if(root==null){
            return;
        }
        process(root,m, 0);
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }
    
    public void process(Node root,TreeMap<Integer,Integer> m,int level){
        if(root == null){
            return;
        }
        m.put(level,root.data); 
        process(root.left,m,level-1);
        process(root.right,m,level+1);
    }
}