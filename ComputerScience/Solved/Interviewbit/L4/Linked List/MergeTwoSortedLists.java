//https://www.interviewbit.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A==null){
            return B;
        }
        else if(B==null){
            return A;
        }
        ListNode result = null;
        if(A.val<=B.val){
            result = A;
            result.next = mergeTwoLists(A.next,B);
        }
        else {
            result = B;
            result.next = mergeTwoLists(A,B.next);
        }
        return result;
    }
}
