//https://www.geeksforgeeks.org/lru-cache-implementation/


/*This is a function problem.You only need to complete the function given below*/
/*You are required to complete below class */
class LRUCache {
 
   Map<Integer,Integer> map;
    int capacity;
    Deque<Integer> dq;
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        this.map = new HashMap<Integer,Integer>();
       this.dq = new LinkedList<>(); 
       this.capacity = N;
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       if(map.get(x)==null){
           return -1;
       }
       dq.remove((Object)x);
       int val = map.get(x);
       map.put(x,val);
       dq.addFirst(x);
       return val;
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
       //Your code here
       if(map.containsKey(x)){
           map.remove(x);
           dq.remove((Object)x);
       }
       if(dq.size() == capacity){
           Integer key = dq.pollLast();
           map.remove(key);
       }
       
       map.put(x,y);
       dq.addFirst(x);
    }
}
