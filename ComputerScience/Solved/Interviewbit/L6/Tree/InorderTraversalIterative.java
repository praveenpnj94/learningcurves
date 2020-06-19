//https://www.interviewbit.com/problems/inorder-traversal/

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
    public int[] inorderTraversal(TreeNode A) {
        if(A==null){
            return new int[0];
        }
        ArrayList<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(A!=null||!st.isEmpty()){
            while(A!=null){
                st.push(A);
                A=A.left;
            }   
            A = st.pop();
            al.add(A.val);
            A=A.right;
        }
        int n = al.size();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=al.get(i);
        }
        return res;
    }
}
