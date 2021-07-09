//https://leetcode.com/problems/reverse-linked-list/
//https://www.youtube.com/watch?v=MRe3UsRadKw

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
    // public ListNode reverseList(ListNode head) {
    //     ListNode prev = null;
    //     ListNode next = null;
    //     ListNode curr = head;
    //     while(curr!=null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }
    
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode first = head;
        ListNode rest = reverseList(first.next);
        first.next.next = first;
        first.next = null;
        return rest;
    }
}