//https://www.interviewbit.com/problems/list-cycle/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode meetingPoint = getMeetingPoint(head);
        if(meetingPoint==null){
            return null;
        }
        ListNode a = head;
        ListNode b = meetingPoint;
        while(a!=b){
            a=a.next;
            b=b.next;
        }
        return a;
    }
    
    public ListNode getMeetingPoint(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }
}
