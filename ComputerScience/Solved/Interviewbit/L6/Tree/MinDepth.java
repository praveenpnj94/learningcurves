//https://www.interviewbit.com/problems/min-depth-of-binary-tree/
//https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/

public class Solution {
	public int minDepth(TreeNode a) {
	    
	    if(a==null)
	       return 0; 
	  
	    if(a.left==null && a.right==null)
	       return 1; 
	   
	    if(a.left==null)
	       return minDepth(a.right) +1; 
	       
	    if(a.right==null)
	        return minDepth(a.left) +1; 
	       
	    int lDepth= minDepth(a.left);
	    int rDepth= minDepth(a.right);
	    
	    return Math.min(lDepth,rDepth)+1; 
	}
}

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
    public int minDepth(TreeNode A) {
        if(A==null){
            return 0;
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(A,0));
        while(!q.isEmpty()){
            Point p = q.poll();
            int dist = p.dist;
            TreeNode node = p.node;
            if(node.left==null && node.right==null){
                return dist+1;
            }
            if(node.left!=null){
                q.add(new Point(node.left,dist+1));
            }
            if(node.right!=null){
                q.add(new Point(node.right,dist+1));
            }
        }
        return -1;
    }
}
class Point{
    TreeNode node;
    int dist;
    Point(TreeNode node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
