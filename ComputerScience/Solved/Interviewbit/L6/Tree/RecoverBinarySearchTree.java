//https://www.interviewbit.com/problems/recover-binary-search-tree/
//https://leetcode.com/problems/recover-binary-search-tree/solution/


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] recoverTree(TreeNode A) {
        if(A==null){
            return new int[0];
        }
        List<Integer> nums = new ArrayList<>();
        inorder(A,nums);
        return findTwoSwapped(nums);
    }
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                // second swap occurence
                else break;
            }
        }
        return new int[]{y, x};
    }
}


class Solution {
    public void inorder(TreeNode root, List<Integer> nums) {
      if (root == null) return;
      inorder(root.left, nums);
      nums.add(root.val);
      inorder(root.right, nums);
    }
  
    public int[] findTwoSwapped(List<Integer> nums) {
      int n = nums.size();
      int x = -1, y = -1;
      for(int i = 0; i < n - 1; ++i) {
        if (nums.get(i + 1) < nums.get(i)) {
          y = nums.get(i + 1);
          // first swap occurence
          if (x == -1) x = nums.get(i);
          // second swap occurence
          else break;
        }
      }
      return new int[]{x, y};
    }
  
    public void recover(TreeNode r, int count, int x, int y) {
      if (r != null) {
        if (r.val == x || r.val == y) {
          r.val = r.val == x ? y : x;
          if (--count == 0) return;
        }
        recover(r.left, count, x, y);
        recover(r.right, count, x, y);
      }
    }
  
    public void recoverTree(TreeNode root) {
      List<Integer> nums = new ArrayList();
      inorder(root, nums);
      int[] swapped = findTwoSwapped(nums);
      recover(root, 2, swapped[0], swapped[1]);
    }
  }

  class Solution {
    public void swap(TreeNode a, TreeNode b) {
      int tmp = a.val;
      a.val = b.val;
      b.val = tmp;
    }
  
    public void recoverTree(TreeNode root) {
      Deque<TreeNode> stack = new ArrayDeque();
      TreeNode x = null, y = null, pred = null;
  
      while (!stack.isEmpty() || root != null) {
        while (root != null) {
          stack.add(root);
          root = root.left;
        }
        root = stack.removeLast();
        if (pred != null && root.val < pred.val) {
          y = root;
          if (x == null) x = pred;
          else break;
        }
        pred = root;
        root = root.right;
      }
  
      swap(x, y);
    }
  }

  class Solution {
    TreeNode x = null, y = null, pred = null;
  
    public void swap(TreeNode a, TreeNode b) {
      int tmp = a.val;
      a.val = b.val;
      b.val = tmp;
    }
  
    public void findTwoSwapped(TreeNode root) {
      if (root == null) return;
      findTwoSwapped(root.left);
      if (pred != null && root.val < pred.val) {
        y = root;
        if (x == null) x = pred;
        else return;
      }
      pred = root;
      findTwoSwapped(root.right);
    }
  
    public void recoverTree(TreeNode root) {
      findTwoSwapped(root);
      swap(x, y);
    }
  }