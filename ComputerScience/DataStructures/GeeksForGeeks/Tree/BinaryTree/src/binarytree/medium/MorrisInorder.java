/**
 * VVIP
 */
package binarytree.medium;

import binarytree.TreeNode;

/**
 * @author praveen on 09-Jul-2018 1:27:02 AM 2018
 */
public class MorrisInorder {
    public static void morrisInorder(TreeNode root) {
        TreeNode current, pre;
        
        if (root == null)
            return;
          
        current = root;
        while(current!=null) {
            if(current.left==null) {
                System.out.print(current.data+" ");
                current = current.right;
            }
            else {
                pre = current.left;
                while (pre.right != null && pre.right != current) 
                    pre = pre.right;
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) 
                {
                    pre.right = current;
                    current = current.left;
                } 
  
                 /* Revert the changes made in if part to restore the 
                    original tree i.e.,fix the right child of predecssor*/
                 else
                 {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                 }
            }
        }
        
    }
}
