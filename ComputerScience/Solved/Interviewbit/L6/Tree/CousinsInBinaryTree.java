//https://www.interviewbit.com/problems/cousins-in-binary-tree/

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
    public ArrayList<Integer> solve(TreeNode root, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null||root.val==B) return res;
    	Queue<TreeNode> queue = new LinkedList<>();
    	 boolean found = false;
    	queue.offer(root);
    	while (!queue.isEmpty() && !found) {
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			TreeNode curr = queue.poll();
                if ((curr.left != null && curr.left.val == B) || 
                     (curr.right != null && curr.right.val == B)) 
                {
                    found = true;
                }
                else
                {
                    if (curr.left != null)
                        queue.add(curr.left);
                    if (curr.right!= null)
                        queue.add(curr.right);
                }
    		}
    	}
    	if(found){
    	   while(!queue.isEmpty()){
    	       TreeNode tn = queue.poll();
    	       res.add(tn.val);
    	    }
    	}
    	return res;
    }
}
