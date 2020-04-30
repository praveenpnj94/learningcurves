//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/
//https://leetcode.com/problems/min-stack/
//https://www.youtube.com/watch?v=ufwPuyxkNVE

class MinStack {
    
    Stack<Integer> s= new Stack<>();
    Stack<Integer> t = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        s.push(x);
        if(t.isEmpty()){
            t.push(x);
        }
        else{
        if(x<=t.peek()){
            t.push(x);
        }            
        }
    }
    
    public void pop() {
        int c =s.peek();
        s.pop();
        if(c==t.peek()){
            t.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        if(t.isEmpty()){
            return -1;
        }
        return t.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */