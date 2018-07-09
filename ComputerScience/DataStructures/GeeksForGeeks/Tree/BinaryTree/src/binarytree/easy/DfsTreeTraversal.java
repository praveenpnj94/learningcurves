/**
 * 
 */
package binarytree.easy;

import java.util.Stack;

import binarytree.CharTreeNode;
import binarytree.TreeNode;

/**
 * @author praveen on 27-Jun-2018 1:23:15 AM 2018
 */
public class DfsTreeTraversal {

    public static void inorder(TreeNode root) {
        if (root == null) { return; }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void inorderIterative(TreeNode root) {
        if (root == null) { return; }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while(curr!=null) {
                s.push(curr);  
                curr = curr.left;             
            }
            if (curr == null) {
                curr = s.pop();
                System.out.print(curr.data + " ");
                curr=curr.right;
            }
        }
    }

    public static void inorder(CharTreeNode root) {
        if (root == null) { return; }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null) { return; }
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) { return; }
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }
}
