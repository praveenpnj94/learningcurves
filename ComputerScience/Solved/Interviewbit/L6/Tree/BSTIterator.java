//https://www.interviewbit.com/problems/bst-iterator/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    ArrayList<Integer> al;
    int idx =0;
    public Solution(TreeNode root) {
        al = new ArrayList<>();
        inorder(root,al);
    }
    
    public void inorder(TreeNode root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);        
    }
    
    

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return idx<al.size();
    }

    /** @return the next smallest number */
    public int next() {
        int val = al.get(idx);
        idx++;
        return val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
