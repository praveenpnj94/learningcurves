//https://leetcode.com/problems/rotate-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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