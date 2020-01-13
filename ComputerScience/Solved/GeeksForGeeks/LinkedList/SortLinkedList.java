//https://www.geeksforgeeks.org/merge-sort-for-linked-list/


class LinkedList
{
    static Node mergeSort(Node head)
    {
                // Base case : if head is null 
        if (head == null || head.next == null) { 
            return head; 
        }
        Node middleNode = getMiddleNode(head);
        Node nextOfMiddle = middleNode.next;
        middleNode.next = null;
        Node a = mergeSort(head);
        Node b = mergeSort(nextOfMiddle);
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
