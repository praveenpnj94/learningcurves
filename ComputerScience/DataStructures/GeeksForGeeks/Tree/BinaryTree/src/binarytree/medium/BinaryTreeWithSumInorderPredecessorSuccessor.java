/**
 * 
 */
package binarytree.medium;

import java.util.ArrayList;
import java.util.List;

import binarytree.TreeNode;

/**
 * @author praveen
 *
 */
public class BinaryTreeWithSumInorderPredecessorSuccessor {
    public static void replaceBinaryTreeWithSumInorderPredecessorSuccessorUtil(TreeNode root) {
        if(root==null) {
            return;
        }
        ArrayList<Integer> al =new ArrayList<Integer>();
        al.add(0);
        storeInorderTraversal(root, al);
        al.add(0);
        System.out.println(al);
        
        replaceNodeWithSum(root, al,new Inde());
        
    }
    public static void storeInorderTraversal(TreeNode root,ArrayList<Integer> al){
        if(root==null) {
            return;
        }
        storeInorderTraversal(root.left, al);
        al.add(root.data);
        storeInorderTraversal(root.right, al);
    }
    public static void replaceNodeWithSum(TreeNode root,ArrayList<Integer> al,Inde ind) {
        if(root==null) {
            return;
        }
        replaceNodeWithSum(root.left, al, ind);
        root.data=al.get(ind.i-1)+al.get(ind.i+1);
        ind.i=ind.i+1;
        replaceNodeWithSum(root.right, al, ind);
    }
}
class Inde{
    int i=1;
}
