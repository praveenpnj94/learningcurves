//https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(-1000);
        ListNode curr= dummy;
        int carry =0;
        int c = 0;
        while(l1!=null && l2!=null){
            int a = l1.val;
            int b = l2.val;
            c = a+b+carry;
            carry = c/10;
            int val = c%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;            
        }
        while(l1!=null){
            c = l1.val+carry;
            carry = c/10;
            int val = c%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr=curr.next;
            l1=l1.next;
        }
        while(l2!=null){
            c = l2.val+carry;
            carry = c/10;
            int val = c%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr=curr.next;
            l2=l2.next;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            curr.next = node;
            curr=curr.next;
            carry=0;
        }
        return dummy.next;
    }
}