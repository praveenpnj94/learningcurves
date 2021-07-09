//https://www.interviewbit.com/problems/reverse-link-list-recursion/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        if(A==null||A.next==null){
            return A;
        }
        ListNode first = A;
        ListNode rest = reverseList(first.next);
        first.next.next = first;
        first.next = null;
        return rest;
    }
}
