//https://www.interviewbit.com/problems/min-stack/

class Solution {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty()){
            s2.push(x);
        }
        else{
            if(x<=s2.peek()){
                s2.push(x);
            }
        }
    }

    public void pop() {
        if(s1.isEmpty()){
            return;
        }
        int val = s1.peek();
        s1.pop();
        if(val==s2.peek()){
            s2.pop();
        }
    }

    public int top() {
        return s1.isEmpty()?-1:s1.peek();
    }

    public int getMin() {
        return s2.isEmpty()?-1:s2.peek();
    }
}
