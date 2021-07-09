//https://www.interviewbit.com/problems/reverse-alternate-k-nodes/
//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list-iterative-solution/



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        return util(A,B,true);
    }
    
    public ListNode util(ListNode A, int B, boolean flag){
        if(A==null||A.next==null){
            return A;
        }
        ListNode curr = A;
        ListNode next = null;
        ListNode prev = null;
        int count=1;
        while(curr!=null && count<=B){
            next = curr.next;
            if(flag){
                curr.next=prev;
            }
            prev=curr;
            curr=next;
            count++;
        }
        if(flag){
            A.next=util(curr,B,!flag);
            return prev;
        }
        prev.next = util(curr,B,!flag);
        return A;
    }
}
