//https://leetcode.com/problems/moving-average-from-data-stream/

//https://www.youtube.com/watch?v=E-kjYOZEBxY

class MovingAverage {
    private Queue<Integer> q;
    private int capacity;
    private double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.capacity = size;
        sum=0;
    }
    
    public double next(int val) {
        if(this.capacity==q.size()){
            int v=q.poll();
            sum-=v;
        }
        q.add(val);
        sum+=val;
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */