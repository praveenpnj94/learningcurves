//https://www.interviewbit.com/problems/reverse-link-list-ii/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1000);
        dummy.next =head;
        ListNode pre = dummy;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode curr=pre.next;
        ListNode next = null;
        for(int i=0;i<n-m;i++){
            next =curr.next;
            curr.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummy.next;
    }
}
