//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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
    // public ListNode deleteDuplicates(ListNode head) {
    //     ListNode curr = head;
    //     ListNode prev=null;
    //     ListNode next=null;
    //     while(curr!=null && curr.next != null){
    //         next=curr.next;
    //         if(next!=null & next.val==curr.val){
    //             curr.next=curr.next.next;
    //         }
    //         else{
    //             curr=curr.next;
    //         }
    //     }
    //     return head;
    // }
    public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
}