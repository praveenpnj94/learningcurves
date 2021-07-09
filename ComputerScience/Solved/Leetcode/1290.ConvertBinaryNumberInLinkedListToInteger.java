//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

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
    // public int getDecimalValue(ListNode head) {
    //     if(head==null){
    //         return 0;
    //     }
    //     ListNode temp = head;
    //     int count =0;
    //     while(temp!=null){
    //         count++;
    //         temp=temp.next;
    //     }
    //     ListNode curr = head;
    //     int res =0;
    //     for(int i=0;i<count;i++){
    //         res=res+(int)Math.pow(2,count-i-1)*curr.val;
    //         curr =curr.next;
    //     }
    //     return res;
    // }
    
    public int getDecimalValue(ListNode head) {
        if(head==null){
            return 0;
        }
        ListNode temp = head;
        int res =0;
        while(temp!=null){
            res*=2;
            res+=temp.val;
            temp=temp.next;
        }
        return res;
    }
}