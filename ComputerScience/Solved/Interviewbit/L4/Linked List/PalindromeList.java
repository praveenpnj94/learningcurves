//https://www.interviewbit.com/problems/palindrome-list/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode head) {
        if(head==null||head.next==null){
            return 1;
        }
        ListNode slow=head;
        ListNode fast =head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow= reverse(slow);
        fast=head;
        return compare(fast,slow);
    }
    
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode next=null;
        ListNode prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public int compare(ListNode a, ListNode b){
        while(a!=null&&b!=null){
            if(a.val!=b.val){
                return 0;
            }
            a=a.next;
            b=b.next;
        }
        return 1;
    }
}
