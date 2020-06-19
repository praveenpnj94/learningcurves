//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/

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
    int preIdx=0;
    HashMap<Integer, Integer> m;
    public TreeNode buildTree(int[] A, int[] B) {
        if(A.length==0||B.length==0){
            return null;
        }
        m = new HashMap<>();
        int idx=0;
        for(int num:B){
            m.put(num,idx);
            idx++;
        }
        int n = B.length;
        return buildTreeUtil(A,B,0, n-1);
    }
    
    public TreeNode buildTreeUtil(int[] A, int[] B,int l, int h) {
        if(l>h){
            return null;
        }
        TreeNode root = new TreeNode(A[preIdx++]);
        int inIdx = m.get(root.val);
        root.left = buildTreeUtil(A,B,l, inIdx-1);
        root.right = buildTreeUtil(A,B,inIdx+1,h);
        return root;
    }
}
