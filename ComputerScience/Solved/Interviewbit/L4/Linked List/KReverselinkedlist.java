//https://www.interviewbit.com/problems/k-reverse-linked-list/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head, int k) {
        	ListNode current = head; 
	ListNode next = null; 
	ListNode prev = null; 
		
	int count = 0; 

	/* Reverse first k nodes of linked list */
	while (count < k && current != null) 
	{ 
		next = current.next; 
		current.next = prev; 
		prev = current; 
		current = next; 
		count++; 
	} 

	/* next is now a pointer to (k+1)th node 
		Recursively call for the list starting from current. 
		And make rest of the list as next of first node */
	if (next != null) 
		head.next = reverseList(next, k); 

	// prev is now head of input list 
	return prev; 
    }
}
