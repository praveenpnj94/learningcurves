//https://www.geeksforgeeks.org/width-binary-tree-set-1/

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
} */
// Function should return vertical width of the binary tree.
class Tree
{
    public static int verticalWidth(Node root)
	{
	    if(root == null){
	        return 0;
	    }
	    TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();
	    int level =0;
	    int count = 0;
	    process(root,m,level);
	    for(Map.Entry<Integer,Integer> entry: m.entrySet()){
	        count++;
	    }
	    return count;
	}
	
	public static void process(Node root,TreeMap<Integer,Integer> m,int level){
	    if(root==null){
	        return;
	    }
	    m.put(level,root.data);
	    process(root.left,m,level-1);
	    process(root.right,m,level+1);
	}
}
