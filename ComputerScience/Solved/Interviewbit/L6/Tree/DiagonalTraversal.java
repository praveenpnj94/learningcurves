//https://www.interviewbit.com/problems/diagonal-traversal/

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
    TreeMap<Integer,List<Integer>> map = null;
public ArrayList<Integer> solve(TreeNode A) {
   ArrayList<Integer> ans = new ArrayList<>();
      map = new TreeMap<Integer,List<Integer>>();
      int level =0;
      inorder(A,map,level);
      for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
          List<Integer> l = entry.getValue();
          for(int num:l){
              ans.add(num);
          }
      }
      return ans;
}

public void inorder(TreeNode root,TreeMap<Integer,List<Integer>> map, int level){
     if(root == null){
         return;
     }
     inorder(root.left,map,level+1);
     List<Integer> l = null;
     if(map.containsKey(level)){
         l = map.get(level);
     }
     else{
         l= new ArrayList<Integer>();
     }
     l.add(root.val);
     map.put(level,l);
     inorder(root.right,map,level);
}
}
