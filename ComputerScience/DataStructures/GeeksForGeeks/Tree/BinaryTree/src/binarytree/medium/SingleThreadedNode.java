/**
 * 
 */
package binarytree.medium;

/**
 * @author praveen on 12-Aug-2018 2:56:35 PM 2018
 */
public class SingleThreadedNode {

    int data;
    SingleThreadedNode left, right;
    boolean rightThread;

    public static SingleThreadedNode getLeftMostNode(SingleThreadedNode root) {
        if (root == null) { return null; }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inOrder(SingleThreadedNode root) {
        SingleThreadedNode temp = getLeftMostNode(root);
        while (temp != null) {
            System.out.print(temp.data + " ");
            if (temp.rightThread) {
                temp = temp.right;
            } else {
                temp = getLeftMostNode(temp.right);
            }
        }
    }

}
