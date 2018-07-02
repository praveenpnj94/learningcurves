/**
 * 
 */
package binarytree.easy;

import binarytree.TreeNode;

/**
 * @author praveen on 30-Jun-2018 6:38:15 PM 2018
 */
public class TreeHeight {

    public static int calculateHeightOfTree(TreeNode root) {
        if (root == null) { return 0; }
        int leftHeight = calculateHeightOfTree(root.left);
        int rightHeight = calculateHeightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
