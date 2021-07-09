//https://leetcode.com/problems/palindrome-linked-list/
//https://www.youtube.com/watch?v=vHam6riSavo&feature=youtu.be&ab_channel=TerribleWhiteboard

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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        // int total = 0;
        // ListNode curr = head;
        // while(curr!=null){
        //     curr=curr.next;
        //     total++;
        // }
        // curr=head;
        // int n=1;
        // ListNode mid =null;
        // ListNode second=null;
        // while(true){
        //     if(n==total/2){
        //         if(total%2==0){
        //             second=curr.next;
        //             curr.next=null;
        //         }
        //         else{
        //             second=curr.next.next;
        //             curr.next =null;
        //         }
        //         break;
        //     }
        //     curr=curr.next;
        //     n++;
        // }
        // if(compare(head,reverse(second))){
        //     return true;
        // }
        // return false;
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
    public boolean compare(ListNode a, ListNode b){
        while(a!=null&&b!=null){
            if(a.val!=b.val){
                return false;
            }
            a=a.next;
            b=b.next;
        }
        return true;
    }
}