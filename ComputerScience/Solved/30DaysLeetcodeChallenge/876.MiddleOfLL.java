//https://leetcode.com/problems/middle-of-the-linked-list/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head!=null){
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }            
        }

        return slow;
    }
}