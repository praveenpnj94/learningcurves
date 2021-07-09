//https://leetcode.com/problems/reverse-nodes-in-k-group/
//https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration

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
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     //1. test weather we have more then k node left, if less then k node left we just return head 
    //     ListNode node = head;
    //     int count = 0;
    //     while (count < k) {
    //         if (node == null) return head;
    //         node = node.next;
    //         count++;
    //     }
    //     // 2.reverse k node at current level 
    //     ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem 
    //     while (count > 0) {
    //         ListNode next = head.next;
    //         head.next = pre;
    //         pre = head;
    //         head = next;
    //         count = count - 1;
    //     }
    //     return pre;
    // }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode node = pointer;
            // first check whether there are k nodes to reverse
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;
            
            // now we know that we have k nodes, we will start from the first node
            ListNode prev = null, curr = pointer.next, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}