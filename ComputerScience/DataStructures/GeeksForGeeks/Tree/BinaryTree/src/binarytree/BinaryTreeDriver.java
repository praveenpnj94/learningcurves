/**
 * 
 */
package binarytree;

import binarytree.easy.DfsTreeTraversal;
import binarytree.easy.TreeMaxMin;
import binarytree.medium.TreeFromArray;
import binarytree.medium.TreeLeftView;

/**
 * @author praveen on 16-Jun-2018 4:20:09 PM 2018
 */
public class BinaryTreeDriver {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);

        /**** code for testing insertion of node *********/
        /*
         InorderTraversal.inorder(tree.root);
         NodeInsertion.insertNode(tree.root, 8); 
         System.out.println("");
         InorderTraversal.inorder(tree.root);
         */
        /************************************************/

        /**** code for testing deletion of node *********/
        /*
         InorderTraversal.inorder(tree.root); 
         int key = 2;
         NodeDeletion.deleteNode(tree.root, key); 
         System.out.println("");
         InorderTraversal.inorder(tree.root);
         */
        /************************************************/

        /**** code for testing level order traversal of tree *********/
        /*
         DfsTreeTraversal.inorder(tree.root); 
         System.out.println(" ");
         LevelOrderTraversal.levelOrder(tree.root); 
         System.out.println(" ");
         DfsTreeTraversal.inorder(tree.root); 
         System.out.println(" ");
         LevelOrderTraversal.levelOrderBruteForce(tree.root);
         */
        /************************************************/

        /**** code for finding max/min in tree *********/
        /*
         System.out.println(TreeMaxMin.findMax(tree.root));
         System.out.println(TreeMaxMin.findMin(tree.root));
         */
        /************************************************/

        /**** code for printing left view of tree *********/

/*        TreeLeftView.getLeftViewIteratively(tree.root);
        System.out.println(" ");
        TreeLeftView.getLeftViewRecursively(tree.root);*/

        /************************************************/
        
        /**** code for Tree implementation using array *********/

/*        BinaryTreeUsingArray obj = new BinaryTreeUsingArray();
        obj.setRoot("A");
        obj.setLeft(0, "B");
        obj.setRight(0, "C");
        obj.setLeft(1, "D");
        obj.setRight(1, "E");
        obj.setLeft(2, "F");
        obj.printTree();*/

        /************************************************/
        
        /**** code for constructing tree from array *********/
        int[] p =new int[]{-1, 0, 0, 1, 1, 3, 5};
        TreeNode node=new TreeFromArray().constructTreeFromArray(p);
        DfsTreeTraversal.inorder(node);

        /************************************************/
    }
}
