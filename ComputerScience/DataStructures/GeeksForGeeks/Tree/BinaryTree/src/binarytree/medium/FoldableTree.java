/**
 *
 */
package binarytree.medium;

import binarytree.TreeNode;
import binarytree.easy.MirrorTree;
import binarytree.easy.SameStructureTree;

/**
 * @author praveen on 07-Aug-2018 11:07:27 PM 2018
 */
public class FoldableTree {

    public static boolean isFoldableTree(TreeNode root) {
        if (root == null) { return true; }
        return isFoldableTreeUtil(root.left, root.right);
    }

    public static boolean isFoldableTreeUtil(TreeNode a, TreeNode b) {
        if (a == null && b == null) { return true; }
        if ((a == null && b != null) || (a != null && b == null)) { return false; }
        return isFoldableTreeUtil(a.left, b.right) && isFoldableTreeUtil(a.right, b.left);
    }

    public static boolean isFoldableTreeByMirror(TreeNode root) {
        boolean res;
        if (root == null) { return true; }
        MirrorTree.findMirror(root.left);
        res = SameStructureTree.isStructureSame(root.left, root.right);
        MirrorTree.findMirror(root.left);
        return res;
    }
}
