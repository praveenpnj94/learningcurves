//https://www.interviewbit.com/problems/postorder-traversal/

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
    public int[] postorderTraversal(TreeNode A) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        if(A==null){
            return new int[l.size()];
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(A);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            l.addFirst(temp.val);
            if(temp.left!=null){
                st.push(temp.left);
            }
            if(temp.right!=null){
                st.push(temp.right);
            }
        }
        int[] res = new int[l.size()];
        for(int i=0;i<l.size();i++){
            res[i]=l.get(i);
        }
        return res;
    }
}
