//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
//https://leetcode.com/problems/diameter-of-binary-tree/solution/
//https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/

/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Tree
{
   /* Complete the function to get diameter of a binary tree */
    int diameter(Node node)
    {
        if(node == null){
            return 0;
        }
        int ld = diameter(node.left);
        int rd = diameter(node.right);
        return (int)Math.max(1+height(node.left)+height(node.right),Math.max(ld,rd));
    }
    int height(Node node){
        if(node == null){
            return 0;
        }
        return 1 + (int)Math.max(height(node.left),height(node.right));
    }
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}
