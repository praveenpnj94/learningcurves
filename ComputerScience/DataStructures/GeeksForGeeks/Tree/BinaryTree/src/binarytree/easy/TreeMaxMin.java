/**
 * 
 */
package binarytree.easy;

import binarytree.TreeNode;

/**
 * @author praveen on 01-Jul-2018 8:52:26 PM 2018
 */
public class TreeMaxMin {

    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int res = root.data;
        int leftmax = findMax(root.left);
        int rightmax = findMax(root.right);
        return Math.max(Math.max(leftmax, rightmax), res);
    }

    public static int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int res = root.data;
        int leftmax = findMin(root.left);
        int rightmax = findMin(root.right);
        return Math.min(Math.min(leftmax, rightmax), res);
    }

}
