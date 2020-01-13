//https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/

class GfG
{
    // head: head node
    Node removeDuplicates(Node root)
    {
        /*Another reference to head*/
        Node curr = root; 
  
        /* Traverse list till the last node */
        while (curr != null) { 
             Node temp = curr; 
            /*Compare current node with the next node and  
            keep on deleting them until it matches the current  
            node data */
            while(temp!=null && temp.data==curr.data) { 
                temp = temp.next; 
            } 
            /*Set current node next to the next different  
            element denoted by temp*/
            curr.next = temp; 
            curr = curr.next; 
        }
        return root;
    }
}
