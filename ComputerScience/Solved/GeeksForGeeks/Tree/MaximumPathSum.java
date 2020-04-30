//https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/


/*This is a function problem.You only need to complete the function given below*/
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class GfG
{
    int max_sum = Integer.MIN_VALUE;
    // This function should returns sum of
    // maximum sum path from any node in
    // a tree rooted with given root.
    int findMaxSum(Node node)
    {
        max_gain(node);
        return max_sum;
    }
    
  public int max_gain(Node node) {
    if (node == null) return 0;

    // max sum on the left and right sub-trees of node
    int left_gain = Math.max(max_gain(node.left), 0);
    int right_gain = Math.max(max_gain(node.right), 0);

    // the price to start a new path where `node` is a highest node
    int price_newpath = node.data + left_gain + right_gain;

    // update max_sum if it's better to start a new path
    max_sum = Math.max(max_sum, price_newpath);

    // for recursion :
    // return the max gain if continue the same path
    return node.data + Math.max(left_gain, right_gain);
  }
}


