//https://www.geeksforgeeks.org/zigzag-tree-traversal/

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
// Print the zig zag traversal of tree.
class GFG
{
	void zigZagTraversal(Node root)
	{
	    Stack<Node> s1 = new Stack<Node>();
	    Stack<Node> s2 = new Stack<Node>();
	    s2.add(root);
	    while(!s1.isEmpty()||!s2.isEmpty()){
	        while(!s1.isEmpty()){
	            Node temp = s1.pop();
	            System.out.print(temp.data+" ");
	            if(temp.right!=null){
	                s2.push(temp.right);
	            }
	            if(temp.left!=null){
	                s2.push(temp.left);
	            }
	        }
	        while(!s2.isEmpty()){
	            Node temp = s2.pop();
	            System.out.print(temp.data+" ");
	            if(temp.left!=null){
	                s1.push(temp.left);
	            }
	            if(temp.right!=null){
	                s1.push(temp.right);
	            }
	        }
	    }
	}
}

//
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if(A==null){
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        boolean rev = false;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<size;i++){
               TreeNode tn = q.poll();
               al.add(tn.val);
               if(tn.left!=null){
                   q.add(tn.left);
               }
               if(tn.right!=null){
                   q.add(tn.right);
               }
            }
            if(rev){
                Collections.reverse(al);
            }
            res.add(al);
            rev=!rev;
        }
        return res;
    }
}
