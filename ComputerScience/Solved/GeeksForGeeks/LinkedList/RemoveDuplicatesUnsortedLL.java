//https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

class GfG
{
    // Function to remove duplicates from the given linked list
    Node removeDuplicates(Node head)
    {
         HashSet<Integer> s = new HashSet<Integer>();
         Node current = head;
         Node prev = null;
         while(current!=null){
             if(s.contains(current.data)){
                 prev.next = current.next;
             }
             else{
                 s.add(current.data);
                 prev = current;
             }
             current = current.next;
         }
         return head;
    }
}
