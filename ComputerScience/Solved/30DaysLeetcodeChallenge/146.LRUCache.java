//https://leetcode.com/problems/lru-cache/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3309/

class LRUCache {

    private HashMap<Integer,Integer> map;
    private Deque<Integer>  dq;
    private int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dq = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
       if(map.get(key)==null){
           return -1;
       }
       dq.remove((Object)key);
       dq.addFirst(key);
       return map.get(key);
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
           map.remove(key);
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */