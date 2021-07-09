//https://www.interviewbit.com/problems/even-reverse/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        if(A==null||A.next==null){
            return A;
        }
        ListNode oddD = new ListNode(-100);
        ListNode odd = oddD;
        ListNode evenD = new ListNode(-100);
        ListNode even = evenD;
        
        ListNode curr = A;
        
        int i=1;
        while(curr!=null){
            if(i%2!=0){
                odd.next = new ListNode(curr.val);
                odd = odd.next;
            }
            else{
                even.next = new ListNode(curr.val);
                even = even.next;
            }
            curr=curr.next;
            i++;
        }
        ListNode rev = reverse(evenD.next);
        ListNode oddAct=oddD.next;
        ListNode point = new ListNode(-100);
        ListNode res = point;
        while(oddAct!=null){
            res.next=oddAct;
            oddAct = oddAct.next;
            
            res=res.next;
            
            if(rev!=null){
                res.next=rev;
                rev = rev.next;
                res=res.next;
            }
        }
        
        return point.next;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode first = head;
        ListNode rest = reverse(first.next);
        first.next.next = first;
        first.next=null;
        return rest;
    }
}
