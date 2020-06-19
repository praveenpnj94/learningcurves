//https://leetcode.com/problems/diameter-of-binary-tree/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
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
    public int diameterOfBinaryTree(TreeNode root) {
        // Height h = new Height();
        // return diameterOfBinaryTreeUtil(root,h);
        		/* base case if tree is empty */
		if (root == null) 
			return 0; 

		/* get the height of left and right sub trees */
		int lheight = height(root.left); 
		int rheight = height(root.right); 

		/* get the diameter of left and right subtrees */
		int ldiameter = diameterOfBinaryTree(root.left); 
		int rdiameter = diameterOfBinaryTree(root.right); 

		/* Return max of following three 
		1) Diameter of left subtree 
		2) Diameter of right subtree 
		3) Height of left subtree + height of right subtree + 1 */
		return Math.max(lheight + rheight, 
						Math.max(ldiameter, rdiameter)); 
    }
    int height(TreeNode node) 
	{ 
		/* base case tree is empty */
		if (node == null) 
			return 0; 

		/* If tree is not empty then height = 1 + max of left 
		height and right heights */
		return (1 + Math.max(height(node.left), height(node.right))); 
	} 
}