/**
 * 
 */
package binarytree.easy;

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
