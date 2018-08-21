package binarytree.medium;

import java.util.ArrayList;
import java.util.List;

import binarytree.TreeNode;

public class AllPossibleBinaryTreeGivenInorderTraversal {

    public static List<TreeNode> getAllPossibleBinaryTreeGivenInorderTraversal(int[] inorder, int start, int end) {
        List<TreeNode> trees=new ArrayList<TreeNode>();
        if(start>end) {
            trees.add(null);
            return trees;
        }
        for(int i=start;i<=end;i++) {
            List<TreeNode> ltrees=getAllPossibleBinaryTreeGivenInorderTraversal(inorder, start, i-1);
            List<TreeNode> rtrees=getAllPossibleBinaryTreeGivenInorderTraversal(inorder, i+1, end);
            for(int j=0;j<ltrees.size();j++) {
                for(int k=0;k<rtrees.size();k++) {
                    TreeNode node=new TreeNode(inorder[i]);
                    node.left=ltrees.get(j);
                    node.right=rtrees.get(k);
                    trees.add(node);
                }
            }

        }
        return trees;
        
    }
}
