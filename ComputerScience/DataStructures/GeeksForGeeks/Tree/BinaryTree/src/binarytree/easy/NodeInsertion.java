/**
 * 
 */
package binarytree.easy;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.TreeNode;

/**
 * @author praveen on 27-Jun-2018 1:01:25 AM 2018
 */
public class NodeInsertion {

    public static void insertNode(TreeNode temp, int data) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp != null) {
                if (temp.left == null) {
                    temp.left = new TreeNode(data);
                    break;
                } else {
                    q.add(temp.left);
                }
                if (temp.right == null) {
                    temp.right = new TreeNode(data);
                    break;
                } else {
                    q.add(temp.right);
                }
            }
        }

    }
}
