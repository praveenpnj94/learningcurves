//https://www.geeksforgeeks.org/queue-linked-list-implementation/

/*This is a function problem.You only need to complete the function given below*/
/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/
class MyQueue
{
    QueueNode front, rear;
    
    // This function should add an item at
    // rear
	void push(int a)
	{
        QueueNode temp = new QueueNode(a);
                // If queue is empty, then new node is front and rear both 
        if (this.rear == null) { 
            this.front = this.rear = temp; 
            return; 
        }
        rear.next = temp;
        rear = temp;
	}
	
    // This function should remove front
    // item from queue and should return
    // the removed item.
	int pop()
	{
        if (this.front == null) 
            return -1; 
        int t = front.data;
        front = front.next;
        if(front==null){
            rear = null;
        }
        return t;
	}
}
