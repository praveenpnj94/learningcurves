class LList
{
    Node head; // Please do not remove this
    
    // Should insert a node at the beginning
	void insertAtBeginning(int x)
	{
	    Node temp = new Node(x);
	    temp.next = head;
	    head = temp;
	}
	
	// Should insert a node at the end
	void insertAtEnd(int x)
	{
	    Node temp = head;
	    if(temp==null){
	        insertAtBeginning(x);
	    }
	    else{
	    while(temp.next!=null){
	        temp = temp.next;
	    }
	    Node last = new Node(x);
	    temp.next = last;	        
	    }
	}
	
	
	
	
	// Please do not delete this
	void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
}