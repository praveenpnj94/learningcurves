import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/


class Clone {
    Node copyList(Node head) {
        // Initialize two references, one with original 
        // list's head. 
        Node origCurr = head, cloneCurr = null; 
  
        // Hash map which contains node to node mapping of 
        // original and clone linked list. 
        Map<Node, Node> map = new HashMap<Node, Node>(); 
  
        // Traverse the original list and make a copy of that 
        // in the clone linked list. 
        while (origCurr != null) 
        { 
            cloneCurr = new Node(origCurr.data); 
            map.put(origCurr, cloneCurr); 
            origCurr = origCurr.next; 
        } 
  
        // Adjusting the original list reference again. 
        origCurr = head; 
  
        // Traversal of original list again to adjust the next 
        // and random references of clone list using hash map. 
        while (origCurr != null) 
        { 
            cloneCurr = map.get(origCurr); 
            cloneCurr.next = map.get(origCurr.next); 
            cloneCurr.arb = map.get(origCurr.arb); 
            origCurr = origCurr.next; 
        } 
  
        //return the head reference of the clone list. 
        return map.get(head);
    }
}
