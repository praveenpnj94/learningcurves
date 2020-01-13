//https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
//https://www.youtube.com/watch?v=oZuR2-AKkXE


class Palindrome
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        Node p = head;
        System.out.println(p.data);
        Node q = head;
        System.out.println(q.data);
        Node secondStart;
        while(true){
            p = p.next.next;
            System.out.println(p.data);
            if(p==null){
                secondStart = q.next;
                break;
            }
            if(p.next==null){
                secondStart = q.next.next;
                break;
            }
            q=q.next;
        }
        q.next = null;
        Node reversed = reverse(secondStart);
        Node temp1 = head;
        Node temp2 = reversed;
        while(temp1!=null && temp2!=null){
            if(temp1.data!=temp2.data){
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp1!=null||temp2!=null){
            return false;
        }
        return true;
    }    
    
    Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


class Palindrome2
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        Node temp =head;
        Stack<Integer> s = new Stack<Integer>();
        while(temp!=null){
            s.push(temp.data);
            temp = temp.next;
        }
        while(head!=null){
            int p = s.pop();
            if(head.data!=p){
                return false;
            }
            head = head.next;
        }
        return true;
    }    
    
    Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
