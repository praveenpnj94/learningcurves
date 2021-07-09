//https://www.interviewbit.com/problems/sort-binary-linked-list/

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
        ListNode curr=A;
        ListNode zeroD = new ListNode(-100);
        ListNode zero = zeroD;
        ListNode oneD = new ListNode(-100);
        ListNode one = oneD;
        ListNode dummy = new ListNode(-100);
        
        while(curr!=null){
            if(curr.val==0){
                zero.next = curr;
                zero=zero.next;
            }
            else if(curr.val==1){
                one.next = curr;
                one=one.next;
            }
            curr=curr.next;
        }
        zero.next = oneD.next;  
        one.next = null;
        A = zeroD.next; 
        return A; 
    }
}


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
        int zero = 0, one = 0;
        while(A != null) {
            if(A.val == 0)
                zero++;
            else
                one++;
            A = A.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while(zero-- > 0) {
            current.next = new ListNode(0);
            current = current.next;
        }
        while(one-- > 0) {
            current.next = new ListNode(1);
            current = current.next;
        }
        return dummyHead.next;
    }
}

