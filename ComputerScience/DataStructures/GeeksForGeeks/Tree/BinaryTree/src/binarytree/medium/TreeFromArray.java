/**
 * FACING ISSUE...CHECK
 */
package binarytree.medium;

import binarytree.TreeNode;

/**
 * @author praveen on 02-Jul-2018 12:45:52 AM 2018
 */
public class TreeFromArray {

    public TreeNode node;

    public TreeNode constructTreeFromArray(int[] parentArray) {
        int n = parentArray.length;
        TreeNode[] created = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            created[i] = null;
        }
        for (int i = 0; i < n; i++) {
            createNode(parentArray, i, created);
        }
        return node;
    }

    public void createNode(int[] parentArray, int i, TreeNode[] created) {
        if (created[i] != null) { return; }
        created[i] = new TreeNode(i);
        if (parentArray[i] == -1) {
            node = new TreeNode(i);
            return;
        }
        // If parent is not created, then create parent first
        if (created[parentArray[i]] == null) {
            createNode(parentArray, parentArray[i], created);
        }

        // Find parent pointer
        TreeNode p = created[parentArray[i]];

        // If this is first child of parent
        if (p.left == null)
            p.left = created[i];
        else // If second child

            p.right = created[i];
    }

}
