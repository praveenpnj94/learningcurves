/**
 * 
 */
package binarytree.medium;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.TreeNode;

/**
 * @author praveen on 01-Jul-2018 10:26:28 PM 2018
 */
public class TreeLeftView {

    private static int maxLevel = 0;

    public static void getLeftViewIteratively(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int i = 0;
            while (i < size) {
                TreeNode temp = q.poll();
                if (i == 0) {
                    System.out.print(temp.data + " ");
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                i++;
            }
        }
    }

    public static void getLeftViewRecursivelyUtil(TreeNode root, int level) {
        if (root == null) { return; }
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        getLeftViewRecursivelyUtil(root.left, level + 1);
        getLeftViewRecursivelyUtil(root.right, level + 1);
    }

    public static void getLeftViewRecursively(TreeNode root) {
        getLeftViewRecursivelyUtil(root,1);
    }

}
