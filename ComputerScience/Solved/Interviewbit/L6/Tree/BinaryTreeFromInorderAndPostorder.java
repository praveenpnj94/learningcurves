//https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/

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
    int pIdx;
    HashMap<Integer, Integer> m;
    public TreeNode buildTree(int[] A, int[] B) {
        if(A.length==0||B.length==0){
            return null;
        }
        m = new HashMap<>();
        int idx=0;
        for(int num:A){
            m.put(num,idx);
            idx++;
        }
        int n = B.length;
        pIdx=n-1;
        return buildTreeUtil(A,B,0, n-1);
    }
    
    public TreeNode buildTreeUtil(int[] A, int[] B,int l, int h) {
        if(l>h){
            return null;
        }
        TreeNode root = new TreeNode(B[pIdx]);
        int inIdx = m.get(root.val);
        pIdx--;
        root.right = buildTreeUtil(A,B,inIdx+1,h);
        root.left = buildTreeUtil(A,B,l, inIdx-1);
        return root;
    }
}
