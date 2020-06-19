//https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> al = new ArrayList<>();
        while(a!=null){
            al.add(a.val);
            a = a.next;
        }
        int low=0;
        int high = al.size()-1;
        return util(al,low,high);
    }
    public TreeNode util(ArrayList<Integer> al,int low, int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode root = new TreeNode(al.get(mid));
        root.left = util(al,low,mid-1);
        root.right = util(al,mid+1,high);
        return root;
    }
}
