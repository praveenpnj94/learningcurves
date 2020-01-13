//https://www.geeksforgeeks.org/array-implementation-of-queue-simple/


/*This is a function problem.You only need to complete the function given below*/
class MyQueue {
    int front, rear;
	int arr[] = new int[1000];
    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	/* The method push to push element
	   into the queue */
	void push(int a)
	{
	    if(rear == 1000){
	        return;
	    }
	    arr[rear] = a;
	    rear = (rear+1)%1000;
	} 
    /* The method pop which return the 
       element poped out of the queue*/
	int pop()
	{
	    if(front==rear){
	        return -1;
	    }
		int t= arr[front];
		front = (front+1)%1000;
		return t;
	} 
}
