/**
 * 
 */
package binarytree.medium;

import binarytree.TreeNode;

/**
 * @author praveen on 05-Jul-2018 2:14:01 AM 2018
 */
public class ContinuousTree {

    public static boolean isContinuousTree(TreeNode root) {
        if (root == null) { return true; }
        if (root.left == null && root.right == null) { return true; }
        if (root.left == null && root.right != null) {
            return (Math.abs(root.data - root.right.data) == 1) && isContinuousTree(root.right);
        }
        if (root.left != null && root.right == null) {
            return (Math.abs(root.data - root.left.data) == 1) && isContinuousTree(root.left);
        }
        return Math.abs(root.data - root.left.data) == 1
                && Math.abs(root.data - root.right.data) == 1 && isContinuousTree(root.left) && isContinuousTree(root.right);
    }

}
