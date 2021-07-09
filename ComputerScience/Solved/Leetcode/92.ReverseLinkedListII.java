//https://leetcode.com/problems/reverse-linked-list-ii/
//https://www.youtube.com/watch?v=wk8-_M-2fzI&ab_channel=leetuition

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
// class Solution {
//     public ListNode reverseBetween(ListNode head, int m, int n) {
//         ListNode dummy = new ListNode(-1000);
//         dummy.next =head;
//         ListNode pre = dummy;
//         for(int i=0;i<m-1;i++){
//             pre=pre.next;
//         }
//         ListNode curr=pre.next;
//         ListNode next = null;
//         for(int i=0;i<n-m;i++){
//             next =curr.next;
//             curr.next=next.next;
//             next.next=pre.next;
//             pre.next=next;
//         }
//         return dummy.next;
//     }
// }

class Solution {
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // You can also expand the code here to get rid of the helper function 'reverseN'
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}