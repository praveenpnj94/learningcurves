//https://www.interviewbit.com/problems/partition-list/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode dummy1 = new ListNode(-1000);
        ListNode smaller = dummy1;
        ListNode dummy2 = new ListNode(-1000);
        ListNode bigger = dummy2;
        while(head!=null){
            if(head.val<x){
                smaller.next=head;
                smaller=smaller.next;
            }
            else{
                bigger.next=head;
                bigger=bigger.next;
            }
            head=head.next;
        }
        bigger.next=null;
        smaller.next=dummy2.next;
        return dummy1.next;
    }
}
