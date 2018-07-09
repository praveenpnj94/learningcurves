/**
 * 
 */
package binarytree.easy;

import binarytree.TreeNode;

/**
 * @author praveen on 07-Aug-2018 11:49:58 PM 2018
 */
public class SameStructureTree {

    public static boolean isStructureSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) { return true; }
        if (a != null && b != null && isStructureSame(a.left, b.left) && isStructureSame(a.right, b.right)) { return true; }
        return false;
    }
}
