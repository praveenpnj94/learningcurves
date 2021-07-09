//https://www.interviewbit.com/problems/rotate-list/
//https://www.youtube.com/watch?v=VX5Fz9z4-CE&ab_channel=AmellPeralta

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int n = 1;
        ListNode curr = head;
        while(curr.next!=null){
            ++n;
            curr=curr.next;
        }
        k=k%n;
        curr.next=head;
        ListNode temp = curr;
        int req = n-k;
        while(req-->0){
            temp=temp.next;
        }
        ListNode newHead = temp.next;
        temp.next=null;
        return newHead;
    }
}
