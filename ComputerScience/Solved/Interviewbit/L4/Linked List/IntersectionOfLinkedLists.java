//https://www.interviewbit.com/problems/intersection-of-linked-lists/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    if(headA==null||headB==null){
            return null;
        }
        HashSet<ListNode> hs = new HashSet<ListNode>();
        while(headA!=null){
            hs.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(hs.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
	}
}
