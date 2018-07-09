/**
 * 
 */
package binarytree;

/**
 * @author praveen on 12-Aug-2018 1:12:00 AM 2018
 */
public class StringBinaryTree {

    public CharTreeNode root;

    public StringBinaryTree() {
        root = null;
    }

    public StringBinaryTree(String data) {
        root = new CharTreeNode(data);
    }
}
