/**
 * 
 */
package binarytree.easy;

import binarytree.TreeNode;

/**
 * @author praveen on 07-Aug-2018 11:45:56 PM 2018
 */
public class MirrorTree {
    public static void findMirror(TreeNode node) {
        if (node == null)
            return;
        else
        {
            TreeNode temp;
  
            findMirror(node.left);
            findMirror(node.right);
  
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
