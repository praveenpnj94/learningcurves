//https://www.interviewbit.com/problems/kth-node-from-middle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) {
        int n =0;
        ListNode curr = A;
        ListNode temp=A;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        int res=n/2+1-B;
        if(res<=0){
            return -1;
        }
        while(--res>0){
            temp=temp.next;
        }
        return temp.val;
    }
}
