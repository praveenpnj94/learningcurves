//https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/

/*This is a function problem.You only need to complete the function given below*/
/*class Tree{
int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class GfG {
    public static Tree convert(Node head, Tree node) {
        Queue<Tree> q = new LinkedList<Tree>();
        
        // Base Case 
        if (head == null)  
        { 
            node = null;  
            return null; 
        }
        
        node = new Tree(head.data);
        q.add(node);
        
        head = head.next;
        while(head!=null){
            Tree parent = q.poll();
            Tree leftChild = null, rightChild = null; 
            leftChild = new Tree(head.data); 
            q.add(leftChild); 
            head = head.next; 
            if (head != null)  
            { 
                rightChild = new Tree(head.data); 
                q.add(rightChild); 
                head = head.next; 
            } 
   
            // 2.b) assign the left and right children of 
            //      parent 
            parent.left = leftChild; 
            parent.right = rightChild;
        }
        return node;
    }
}
    
    
    