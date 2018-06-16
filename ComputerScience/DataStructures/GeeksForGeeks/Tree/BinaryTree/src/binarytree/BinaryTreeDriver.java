/**
 * 
 */
package binarytree;

/**
 * @author praveen on 16-Jun-2018 4:20:09 PM 2018
 */
public class BinaryTreeDriver {
    public static void main(String[] args) {
        BinaryTree tree =new BinaryTree();
        tree.root=new TreeNode(1);
        tree.root.left=new TreeNode(2);
        tree.root.right=new TreeNode(3);
        tree.root.left.left=new TreeNode(4);
    }
}
