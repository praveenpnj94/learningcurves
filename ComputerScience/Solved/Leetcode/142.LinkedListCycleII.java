//https://leetcode.com/problems/linked-list-cycle-ii/

//https://leetcode.com/problems/linked-list-cycle-ii/solution/
//https://www.youtube.com/watch?v=yKNOZ8bPdRQ&list=PL6Zs6LgrJj3tFNF3RvHDAvZcgOrvGWNRi&index=30&ab_channel=DineshVaryani
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
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