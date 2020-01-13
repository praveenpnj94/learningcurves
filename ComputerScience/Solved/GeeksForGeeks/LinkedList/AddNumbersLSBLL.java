//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/


// Java program to add two numbers represented by linked list 

class GFG {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    public static Node sum(Node l1, Node l2)
    {
        if(l2 == null) return l1;
        if(l1 == null) return l2;


        // storing head whose reverse is to be returned
        // This is where which will be final node
        Node head = l1;
        Node prev = null;
        int c = 0,sum;
        while(l1 != null && l2 != null)
        {
            sum = c + l1.data + l2.data;
            l1.data = sum % 10;
            c = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 != null||l2 != null)
        {
            if(l2 != null) prev.next = l2;
            l1 = prev.next;
            while(l1 != null)
            {
                sum = c + l1.data;
                l1.data = sum % 10;
                c = sum / 10;
                prev = l1;
                l1 = l1.next;
            }
        }
        if(c > 0) prev.next = new Node(c);
        return head;
    }

    /* Adds contents of two linked lists and return the head node of resultant list */
    Node addTwoLists(Node first, Node second) {
        Node res = null; // res is head node of the resultant list
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (first != null || second != null) //while both lists exist
        {
            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i) Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new Node(sum);

            // if this is the first node then set it as head of
            // the resultant list
            if (res == null) {
                res = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // return head of the resultant list
        return res;
    }
    /* Utility function to print a linked list */

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        GFG list = new GFG();

        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
}

// this code has been contributed by Mayank Jaiswal 
