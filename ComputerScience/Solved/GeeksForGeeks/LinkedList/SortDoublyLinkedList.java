//https://www.geeksforgeeks.org/merge-sort-for-doubly-linked-list/

class LinkedList
{
    static Node sortDoubly(Node head)
    {
                // Base case : if head is null 
        if (head == null || head.next == null) { 
            return head; 
        }
        Node second = split(head);
        Node a = sortDoubly(head);
        Node b = sortDoubly(second);
        Node c = merge(a,b);
        return c;
    }
    
    static Node split(Node head){
        if (head == null) 
            return head; 
        Node fast = head;
        Node slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next; 
        slow.next = null; 
        return temp; 
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
           a.next.prev = a;
           a.prev = null;
           return a;
        }else{
           b.next = merge(a,b.next);
           b.next.prev = b;
           b.prev = null;
           return b;
        }
    }
}