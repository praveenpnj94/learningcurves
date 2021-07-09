//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int preIdx =0;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0||inorder==null||inorder.length==0){
            return null;
        }
        map=new HashMap<>(); 
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return util(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode util(int[] preorder, int[] inorder, int low, int high){
        if(low>high){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int idx = map.get(root.val);
        root.left = util(preorder,inorder,low,idx-1);
        root.right = util(preorder,inorder,idx+1,high);
        return root;
        
    }
}