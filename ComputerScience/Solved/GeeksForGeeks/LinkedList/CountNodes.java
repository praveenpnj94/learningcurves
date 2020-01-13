class CountNodes{
    public int getCount(Node head){
        
        int count =0;
        Node temp = head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    
}