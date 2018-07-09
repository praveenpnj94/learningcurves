/**
 * 
 */
package binarytree.easy;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.TreeNode;

/**
 * @author praveen on 12-Aug-2018 1:53:34 AM 2018
 */
public class SymmetricTree {

    public static boolean isSymmetricTree(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) { return true; }
        if (a != null && b != null && a.data == b.data) { return isMirror(a.left, b.right) && isMirror(a.right, b.left); }
        return false;
    }

    public static boolean isSymmetricTreeIteratively(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode tempLeft = q.poll();
            TreeNode tempRight = q.poll();
            if (tempLeft == null && tempRight == null) { continue; }
            if ((tempLeft != null && tempRight == null) || (tempLeft == null && tempRight != null)) { return false; }
            if (tempLeft != null && tempRight != null) {
                if (tempLeft.data == tempRight.data) { return true; }
                return false;
            }
            q.add(tempLeft.left);
            q.add(tempRight.right);
            q.add(tempLeft.right);
            q.add(tempRight.left);
        }
        return true;
    }
}
