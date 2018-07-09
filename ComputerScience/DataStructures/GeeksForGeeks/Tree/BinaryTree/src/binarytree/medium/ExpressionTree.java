/**
 * 
 */
package binarytree.medium;

import java.util.Stack;

import binarytree.CharTreeNode;

/**
 * @author praveen on 08-Aug-2018 12:59:03 AM 2018
 */
public class ExpressionTree {

    public static CharTreeNode constructExpressionTree(char postfix[]) {
        Stack<CharTreeNode> s = new Stack<CharTreeNode>();
        CharTreeNode t, t1, t2;
        for (int i = 0; i < postfix.length; i++) {
            if (!String.valueOf(postfix[i]).equals("+") && !String.valueOf(postfix[i]).equals("-") && !String.valueOf(postfix[i]).equals("*") && !String.valueOf(postfix[i]).equals("/") && !String.valueOf(postfix[i]).equals("^")) {
                s.push(new CharTreeNode(String.valueOf(postfix[i])));
            } else {
                t = new CharTreeNode(String.valueOf(postfix[i]));
                t1 = s.pop();
                t2 = s.pop();
                t.left = t2;
                t.right = t1;
                s.push(t);
            }
        }
        t = s.pop();
        return t;
    }

    public static int evalTree(CharTreeNode root) {
        if (root == null) return 0;

        if (root.left == null || root.right == null) return Integer.parseInt(root.data);

        // Evaluate left subtree
        int leftValue = evalTree(root.left);

        // Evaluate right subtree
        int rightValue = evalTree(root.right);

        // Check which operator to apply
        if (root.data.equals("+")) return leftValue + rightValue;

        if (root.data.equals("-")) return leftValue - rightValue;

        if (root.data.equals("*")) return leftValue * rightValue;

        return leftValue / rightValue;
    }
}
