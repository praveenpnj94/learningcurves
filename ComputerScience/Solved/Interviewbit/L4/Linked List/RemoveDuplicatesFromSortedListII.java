//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        if(head.val!=head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        ListNode curr=head;
        while(curr!=null && curr.val==head.val){
            curr=curr.next;
        }
        return deleteDuplicates(curr);
    }
}
