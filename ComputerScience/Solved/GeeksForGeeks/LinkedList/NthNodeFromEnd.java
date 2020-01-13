//https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/


/*This is a function problem.You only need to complete the function given below*/
/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/
class GfG
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node curr = head;
    	Node slow = head;
    	int j =0;
    	while(curr!=null){
    	    if(j>=n){
    	        slow =slow.next;
    	    }
    	    curr = curr.next;
    	    j++;
    	}
    	if(n>j){
    	    return -1;
    	}
    	return slow.data;
    }
}
