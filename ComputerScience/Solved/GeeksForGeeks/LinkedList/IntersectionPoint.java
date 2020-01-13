//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/


class Intersect
{
    int intersectPoint(Node head1, Node head2)
	{
	    int c1 = getCount(head1); 
        int c2 = getCount(head2); 
        int d; 
  
        if (c1 > c2) { 
            d = c1 - c2; 
            return _getIntesectionNode(d, head1, head2); 
        } 
        else { 
            d = c2 - c1; 
            return _getIntesectionNode(d, head2, head1); 
        } 
	}
	
	int getCount(Node node) 
    { 
        Node current = node; 
        int count = 0; 
  
        while (current != null) { 
            count++; 
            current = current.next; 
        } 
  
        return count; 
    }
    
    int _getIntesectionNode(int d, Node node1, Node node2) 
    { 
        int i; 
        Node current1 = node1; 
        Node current2 = node2; 
        for (i = 0; i < d; i++) { 
            if (current1 == null) { 
                return -1; 
            } 
            current1 = current1.next; 
        } 
        while (current1 != null && current2 != null) { 
            if (current1.data == current2.data) { 
                return current1.data; 
            } 
            current1 = current1.next; 
            current2 = current2.next; 
        } 
  
        return -1; 
    } 
	
	int intersectPoint2(Node headA, Node headB)
	{
         LinkedHashSet<Node> lh = new LinkedHashSet<Node>();
         while(headA!=null){
             lh.add(headA);
             headA = headA.next;
         }
         while(headB!=null){
             if(lh.contains(headB)){
                 return headB.data;
             }
             headB = headB.next;
         }
         return -1;
	}
}
