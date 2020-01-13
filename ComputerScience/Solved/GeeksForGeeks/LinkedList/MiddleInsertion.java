//https://www.geeksforgeeks.org/insert-node-middle-linked-list/


class Solution {
    
    public Node insertInMid(Node head, int data){
        Node fast = head.next;
        Node slow = head;
        if(head==null){
            head= new Node(data);
        }
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        Node mynode = new Node(data);
        mynode.next = temp;
        slow.next = mynode;
        return head;
    }


    static void insertAtMid(int x) 
    { 
        // if list is empty 
        if (head == null) 
            head = new Node(x); 
        else { 
            // get a new node 
            Node newNode = new Node(x); 
  
            Node ptr = head; 
            int len = 0; 
  
            // calculate length of the linked list 
            //, i.e, the number of nodes 
            while (ptr != null) { 
                len++; 
                ptr = ptr.next; 
            } 
  
            // 'count' the number of nodes after which 
            // the new node is to be inserted 
            int count = ((len % 2) == 0) ? (len / 2) : 
                                        (len + 1) / 2; 
            ptr = head; 
  
            // 'ptr' points to the node after which  
            // the new node is to be inserted 
            while (count-- > 1) 
                ptr = ptr.next; 
  
            // insert the 'newNode' and adjust  
            // the required links 
            newNode.next = ptr.next; 
            ptr.next = newNode; 
        } 
    } 
}