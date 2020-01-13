//https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/


//Function should return the length of the loop in LL.
class Loop
{
    int countNodesinLoop(Node head)
    {
	    Node slow = head;
	    Node fast = head;
	    while(slow!=null && fast!= null && fast.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow==fast){
	            return countNodes(slow);
	        }
	    }
	    return 0;
    }
    
    int countNodes(Node n){
        int res=1;
        Node temp = n;
        while(temp.next!=n){
            res++;
            temp = temp.next;
        }
        return res;
    }
}