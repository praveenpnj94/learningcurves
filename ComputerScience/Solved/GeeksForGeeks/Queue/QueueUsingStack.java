class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    /* The method insert to push element
       into the queue */
    void insert(int B)
    {
	   s1.push(B);
    }
	
    
    /* The method remove which return the
      element popped out of the queue*/
    int remove()
    {
	   if(s2.isEmpty()){
	       while(!s1.isEmpty()){
	           s2.push(s1.pop());
	       }
	   }
	   return s2.isEmpty()?-1:s2.pop();
    }
}
