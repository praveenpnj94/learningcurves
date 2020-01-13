//

import java.util.*;
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
class DLinkedList
{

    Node newNode(Node head, int data)
    {
        Node p;
        Node temp = new Node(data);
        if(head == null)
            return temp;
        p = head;
        while(p.next != null)
        {
            p = p.next;
        }
        p.next = temp;
        temp.prev = p;
        return head;
    }


    void printList(Node node)
    {
        Node temp = node;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        while(temp.prev != null)
        {
            temp = temp.prev;
        }

        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
/*This is a function problem.You only need to complete the function given below*/
/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        DLinkedList DLL = new DLinkedList();
        int t = sc.nextInt();

        while(t>0)
        {
            Node temp;
            Node head = null;
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
            {
                int x = sc.nextInt();
                head = DLL.newNode(head,x);
            }
            int pos = sc.nextInt();
            int data = sc.nextInt();

            GFG g = new GFG();
            g.addNode(head,pos,data);

            DLL.printList(head);
            while(head.next != null)
            {
                temp = head;
                head = head.next;
            }
            t--;
        }
    }
    void addNode(Node head_ref, int pos, int data)
    {
        int i=0;
        Node temp = head_ref;
        Node prev = null;
        while(i<pos){
            prev = temp;
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        if(temp.next==null){
            temp.next = newNode;
            newNode.prev = temp;
        }
        else{
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
        }
    }
}