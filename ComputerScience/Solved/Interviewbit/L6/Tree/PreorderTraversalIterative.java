//https://www.interviewbit.com/problems/preorder-traversal/

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
    public int[] preorderTraversal(TreeNode A) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(A);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            al.add(temp.val);
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
        int n = al.size();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=al.get(i);
        }
        return res;
    }
}
