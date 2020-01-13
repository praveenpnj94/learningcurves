class MyStack {
    // Note that top is by default null
    // in Java
    StackNode top;
    void push(int a) {
        StackNode newNode = new StackNode(a);
        if(top==null){
            top = newNode;
        }
        else{
            StackNode temp = top;
            newNode.next = temp;
            top = newNode;
        }
    }
    int pop() {
        if(top == null){
            return -1;
        }
        int d = top.data;
        StackNode n = top.next;
        top = n;
        return d;
    }
}