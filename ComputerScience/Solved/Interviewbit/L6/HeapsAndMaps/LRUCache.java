//https://www.interviewbit.com/problems/lru-cache/

public class Solution {
    HashMap<Integer,Integer> map;
    Deque<Integer> dq;
    int capacity;
    
    public Solution(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dq = new LinkedList<>();
    }
    
    public int get(int key) {
       if(map.get(key)==null){
           return -1;
       }
       dq.remove((Object)key);
       dq.addFirst(key);
       return map.get(key);
    }
    
    public void set(int key, int value) {
       if(map.containsKey(key)){
           dq.remove((Object)key);
       }
       if(dq.size() == capacity){
           Integer k = dq.pollLast();
           map.remove(k);
       }
       map.put(key,value);
       dq.addFirst(key);   
    }
}