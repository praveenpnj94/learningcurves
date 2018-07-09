/**
 * 
 */
package binarytree;

import binarytree.easy.DfsTreeTraversal;
import binarytree.easy.MirrorTree;
import binarytree.easy.NodeInsertion;
import binarytree.easy.SameStructureTree;
import binarytree.easy.SymmetricTree;
import binarytree.easy.TreeMaxMin;
import binarytree.medium.ContinuousTree;
import binarytree.medium.ExpressionTree;
import binarytree.medium.FoldableTree;
import binarytree.medium.MorrisInorder;
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
        tree.root.left.left = new TreeNode(3);

        /**** code for testing insertion of node *********/
/*        
         DfsTreeTraversal.inorder(tree.root);
         NodeInsertion.insertNode(tree.root, 8); 
         System.out.println("");
         DfsTreeTraversal.inorderIterative(tree.root);*/
         
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
/*        int[] p =new int[]{-1, 0, 0, 1, 1, 3, 5};
        TreeNode node=new TreeFromArray().constructTreeFromArray(p);
        DfsTreeTraversal.inorder(node);*/

        /************************************************/
        
        /**** code for checking whether tree is continuous or not *********/
        //System.out.println(ContinuousTree.isContinuousTree(tree.root));

        /************************************************/
        
        /*******code for checking foldable binary tree*******************/
/*        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.right.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(5);
  
        if (FoldableTree.isFoldableTree(binaryTree.root))
            System.out.println("Tree is foldable");
        else
            System.out.println("Tree is not foldable");
        
        if (FoldableTree.isFoldableTreeByMirror(binaryTree.root))
            System.out.println("Tree is foldable");
        else
            System.out.println("Tree is not foldable");*/
        
        /******************************************************************/
        
        /*******code for constructing expression tree*******************/
/*        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        CharTreeNode root = et.constructExpressionTree(charArray);
        System.out.println("infix expression is");
        DfsTreeTraversal.inorder(root);*/
        
        /******************************************************************/
        
        /***************Code for evaluating expression****************************/       
/*        CharTreeNode root = new CharTreeNode("+");
        root.left = new CharTreeNode("*");
        root.left.left = new CharTreeNode("5");
        root.left.right = new CharTreeNode("4");
        root.right = new CharTreeNode("-");
        root.right.left = new CharTreeNode("100");
        root.right.right = new CharTreeNode("/");
        root.right.right.left = new CharTreeNode("20");
        root.right.right.right = new CharTreeNode("2");
        System.out.println(ExpressionTree.evalTree(root));*/
        
        /******************************************************************/
        
        /***************Code for determing symmetric tree****************************/       
/*        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        //boolean output =SymmetricTree.isSymmetricTree(root);
        boolean output =SymmetricTree.isSymmetricTreeIteratively(root);
        if (output == true)
            System.out.println("1");
        else
            System.out.println("0");*/
        
        /******************************************************************/
        
        /***************Code for Morris Inorder Traversal****************************/       
        MorrisInorder.morrisInorder(tree.root);
        
        /******************************************************************/
    }
}
