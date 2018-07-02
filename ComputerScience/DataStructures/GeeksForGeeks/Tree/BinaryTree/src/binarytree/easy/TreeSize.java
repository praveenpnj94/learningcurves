/**
 * 
 */
package binarytree.easy;

import binarytree.TreeNode;

/**
 * @author praveen on 01-Jul-2018 7:32:27 PM 2018
 */
public class TreeSize {

    public static int getSize(TreeNode root) {
        if (root == null) { return 0; }
        int leftSize = getSize(root.left);
        int rightSize = getSize(root.right);
        return leftSize + rightSize + 1;
    }
}
