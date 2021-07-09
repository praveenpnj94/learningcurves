//https://leetcode.com/problems/find-median-from-data-stream/
//https://www.youtube.com/watch?v=VmogG01IjYc

class MedianFinder {
    PriorityQueue<Integer> lowers;
    PriorityQueue<Integer> highers;

    /** initialize your data structure here. */
    public MedianFinder() {
        lowers = new PriorityQueue<Integer>((a,b)->b-a);
        highers = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(lowers.size()==0||num<lowers.peek()){
            lowers.add(num);
        }
        else{
            highers.add(num);
        }
        rebalance(lowers,highers);
    }
    
    public void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        PriorityQueue<Integer> bigger = lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smaller = lowers.size()>highers.size()?highers:lowers;
        if(bigger.size()-smaller.size()>=2){
            smaller.add(bigger.poll());
        }
    }
    
    public double findMedian() {
        PriorityQueue<Integer> bigger = lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smaller = lowers.size()>highers.size()?highers:lowers;
        if(bigger.size()==smaller.size()){
            return ((double)bigger.peek() + smaller.peek())/2;
        }
        else{
            return (double)bigger.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */