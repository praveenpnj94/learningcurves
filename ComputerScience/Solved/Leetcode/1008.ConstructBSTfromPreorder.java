//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

//My solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static int preIndex;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=preorder[i];
        }
        Arrays.sort(inorder);
        preIndex = 0;
        TreeNode root = constructTree(inorder,preorder,0,n-1);
        return root;
    }
    public TreeNode constructTree(int[] in, int[] pre, int st, int end){
        HashMap<Integer,Integer> m = new HashMap<>();
        int idx=0;
        for(int i:in){
            m.put(i,idx);
            idx++;
        }
        if(st>end){
            return null;
        }
        TreeNode node = new TreeNode(pre[preIndex++]);
        int index = m.get(node.val);
        node.left = constructTree(in,pre,st,index-1);
        node.right = constructTree(in,pre,index+1,end);
        return node;
    }
}

//o(n) recursion
class Solution {
    int idx = 0;
    int[] preorder;
    int n;
  
    public TreeNode helper(int lower, int upper) {
      // if all elements from preorder are used
      // then the tree is constructed
      if (idx == n) return null;
  
      int val = preorder[idx];
      // if the current element 
      // couldn't be placed here to meet BST requirements
      if (val < lower || val > upper) return null;
  
      // place the current element
      // and recursively construct subtrees
      idx++;
      TreeNode root = new TreeNode(val);
      root.left = helper(lower, val);
      root.right = helper(val, upper);
      return root;
    }
  
    public TreeNode bstFromPreorder(int[] preorder) {
      this.preorder = preorder;
      n = preorder.length;
      return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
  }

//o(n) iteration
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
      int n = preorder.length;
      if (n == 0) return null;
  
      TreeNode root = new TreeNode(preorder[0]);
      Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
      deque.push(root);
  
      for (int i = 1; i < n; i++) {
        // take the last element of the deque as a parent
        // and create a child from the next preorder element
        TreeNode node = deque.peek();
        TreeNode child = new TreeNode(preorder[i]);
        // adjust the parent 
        while (!deque.isEmpty() && deque.peek().val < child.val)
          node = deque.pop();
  
        // follow BST logic to create a parent-child link
        if (node.val < child.val) node.right = child;
        else node.left = child;
        // add the child into deque
        deque.push(child);
      }
      return root;
    }
  }