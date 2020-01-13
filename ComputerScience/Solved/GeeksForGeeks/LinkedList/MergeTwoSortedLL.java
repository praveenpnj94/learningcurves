//https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
//https://www.geeksforgeeks.org/merge-two-sorted-lists-place/


/*This is a function problem.You only need to complete the function given below*/
/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
     // This is a "method-only" submission. 
     // You only need to complete this method
     if(headA==null){
         return headB;
     }
     if(headB==null){
         return headA;
     }
     if(headA.data<headB.data){
         headA.next = sortedMerge(headA.next,headB);
         return headA;
     }
     else{
         headB.next = sortedMerge(headA,headB.next);
         return headB;
     }
   } 

   /* Takes two lists sorted in  
increasing order, and splices  
their nodes together to make  
one big sorted list which is  
returned. */
Node sortedMerge2(Node headA, Node headB) 
{ 
      
    /* a dummy first node to  
       hang the result on */
    Node dummyNode = new Node(0); 
      
    /* tail points to the  
    last result node */
    Node tail = dummyNode; 
    while(true)  
    { 
          
        /* if either list runs out,  
        use the other list */
        if(headA == null) 
        { 
            tail.next = headB; 
            break; 
        } 
        if(headB == null) 
        { 
            tail.next = headA; 
            break; 
        } 
          
        /* Compare the data of the two 
        lists whichever lists' data is  
        smaller, append it into tail and 
        advance the head to the next Node 
        */
        if(headA.data <= headB.data) 
        { 
            tail.next = headA; 
            headA = headA.next; 
        }  
        else
        { 
            tail.next = headB; 
            headB = headB.next; 
        } 
          
        /* Advance the tail */
        tail = tail.next; 
    } 
    return dummyNode.next; 
} 
}
