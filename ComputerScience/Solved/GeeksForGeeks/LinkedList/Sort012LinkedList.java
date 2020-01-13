//https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
//https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/


class LinkedList
{
    public static Node segregate(Node head) 
    { 
        if(head==null || head.next==null) 
        { 
            return head; 
        } 
        // Create three dummy nodes to point to  
        // beginning of three linked lists. These  
        // dummy nodes are created to avoid many  
        // null checks.  
        Node zeroD = new Node(0);  
        Node oneD = new Node(0);  
        Node twoD = new Node(0);  
  
        // Initialize current pointers for three  
        // lists and whole list.  
        Node zero = zeroD, one = oneD, two = twoD;  
        // Traverse list  
        Node curr = head;  
        while (curr!=null)  
        {  
            if (curr.data == 0)  
            {  
                zero.next = curr;  
                zero = zero.next;  
                curr = curr.next;  
            } 
            else if (curr.data == 1)  
            {  
                one.next = curr;  
                one = one.next;  
                curr = curr.next;  
            }  
            else 
            {  
                two.next = curr;  
                two = two.next;  
                curr = curr.next;  
            }  
        } 
        // Attach three lists  
        zero.next = (oneD.next!=null) ? (oneD.next) : (twoD.next);  
        one.next = twoD.next;  
        two.next = null; 
        // Updated head  
        head = zeroD.next; 
        return head; 
    }     
    
    static Node segregate3(Node head){
        int[] count = {0,0,0};
        Node temp = head;
        while(temp!=null){
            count[temp.data]++;
            temp=temp.next;
        }
       int i = 0; 
       Node ptr = head; 
  
       /* Let say count[0] = n1, count[1] = n2 and count[2] = n3 
        * now start traversing list from head node, 
        * 1) fill the list with 0, till n1 > 0 
        * 2) fill the list with 1, till n2 > 0 
        * 3) fill the list with 2, till n3 > 0  */
        while (ptr != null)  
        { 
            if (count[i] == 0) 
                i++; 
            else 
            { 
               ptr.data= i; 
               --count[i]; 
               ptr = ptr.next; 
            } 
         }
         return head;
    }
    static Node segregate2(Node head)
    {
                // Base case : if head is null 
        if (head == null || head.next == null) { 
            return head; 
        }
        Node middleNode = getMiddleNode(head);
        Node nextOfMiddle = middleNode.next;
        middleNode.next = null;
        Node a = segregate2(head);
        Node b = segregate2(nextOfMiddle);
        Node c = merge(a,b);
        return c;
    }
    
    static Node getMiddleNode(Node head){
        if (head == null) 
            return head; 
        Node fast = head;
        Node slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    static Node merge(Node a, Node b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<b.data){
           a.next =  merge(a.next,b);
           return a;
        }else{
           b.next = merge(a,b.next);
           return b;
        }
    }
}