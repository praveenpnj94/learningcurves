//https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
//https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
//https://www.youtube.com/watch?v=jiLloHVmLDc


// Java program to pairwise swap elements of a linked list
class LinkedList {
    static Node head; // head of list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void pairWiseSwapData()
    {
        Node temp = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

    void pairWiseSwapRecursionData(Node head)
    {
        if(head!=null && head.next!=null){
            swap(head,head.next);
            pairWiseSwapRecursionData(head.next.next);
        }
    }

    /* Function to pairwise swap elements of a linked list */
    Node pairWiseSwapLink(Node node)
    {
        Node p = node;
        Node r = p.next;
        Node q = null;
        Node temp = null;
        while(true){
            q=p.next;
            temp=q.next;
            q.next=p;
            if(temp==null||temp.next==null){
                p.next=temp;
                break;
            }
            p.next=temp.next;
            p = temp;
        }
        return r;
    }

    void swap(Node a, Node b){
        int temp =a.data ;
        a.data=b.data;
        b.data= temp;
    }

    Node pairWiseSwapLinkRecursive(Node node)
    {

        // Base Case: The list is empty or has only one node
        if (node == null || node.next == null) {
            return node;
        }

        // Store head of list after two nodes
        Node remaing = node.next.next;

        // Change head
        Node newhead = node.next;

        // Change next of second node
        node.next.next = node;

        // Recur for remaining list and change next of head
        node.next = pairWiseSwapLinkRecursive(remaing);

        // Return new head of modified list
        return newhead;
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Function to print nodes in a given linked list */
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();

        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();

        //llist.pairWiseSwapRecursionData(head);
        Node t = llist.pairWiseSwapLinkRecursive(head);

        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.printList(t);
    }
}
/* This code is contributed by Rajat Mishra */
