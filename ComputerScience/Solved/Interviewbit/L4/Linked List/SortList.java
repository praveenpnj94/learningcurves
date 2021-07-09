//https://www.interviewbit.com/problems/sort-list/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode A) {
        if(A==null||A.next==null){
            return A;
        }
        ListNode middle = getMiddle(A);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode l =  sortList(A);
        ListNode r = sortList(nextOfMiddle);
        return merge(l,r);
    }
    
    public ListNode getMiddle(ListNode head){
        if(head==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode l,ListNode r){
        if(l==null){
            return r;
        }
        if(r==null){
            return l;
        }
        ListNode res=null;
        if(l.val<=r.val){
            res=l;
            res.next=merge(l.next,r);
        }
        else{
            res=r;
            res.next=merge(l,r.next); 
        }
        return res;
    }
}
