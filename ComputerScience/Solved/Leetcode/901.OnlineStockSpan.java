//https://leetcode.com/problems/online-stock-span/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/

class StockSpanner {
    Stack<int[]> s;
    
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int span =1;
        while(!s.isEmpty() && price>=s.peek()[0]){
            span+=s.pop()[1];
        }
        s.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */