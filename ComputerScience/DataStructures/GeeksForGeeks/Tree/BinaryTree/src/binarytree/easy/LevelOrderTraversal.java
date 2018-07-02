/**
 * 
 */
package binarytree.easy;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.TreeNode;

/**
 * @author praveen on 30-Jun-2018 4:44:21 PM 2018
 */
public class LevelOrderTraversal {

    public static void levelOrder(TreeNode node) {
        Queue<TreeNode> q = new LinkedList();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static void levelOrderBruteForce(TreeNode node) {
        for (int i = 0; i < TreeHeight.calculateHeightOfTree(node); i++) {
            printGivenLevel(node, i + 1);
        }
    }

    private static void printGivenLevel(TreeNode root, int level) {
        if (root == null) return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}
