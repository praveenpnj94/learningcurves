/**
 * Important
 */
package binarytree.easy;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.TreeNode;

/**
 * @author praveen on 30-Jun-2018 2:08:03 AM 2018
 */
public class NodeDeletion {

    public static void deleteNode(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode temp = null;
        TreeNode keyNode = null;
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.data == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        int x = temp.data;
        deleteDeepest(root, temp);
        keyNode.data = x;
    }

    private static void deleteDeepest(TreeNode root, TreeNode delNode) {
        TreeNode temp = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else
                    q.add(temp.left);
            }
        }
    }
}
