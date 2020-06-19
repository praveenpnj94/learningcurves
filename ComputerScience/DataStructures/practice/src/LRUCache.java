import java.util.*;
import java.util.LinkedList;

public class LRUCache {

    private HashMap<Integer,Integer> map;
    private Queue<Integer> queue;
    private int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = -1;
        if(map.containsKey(key)){
            val = map.get(key);
        }
        queue.offer(key);
        return val;
    }

    public void put(int key, int value) {
        if(queue.size()==capacity){
            int k = queue.peek();
            map.remove(k);
            queue.poll();
        }
        queue.add(key);
        map.put(key,map.getOrDefault(key,0)+1);
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        HashMap<Integer,Integer> m = new LinkedHashMap<>();
        for(int i=0;i<a.size();i++){
            m.put(a.get(i),m.getOrDefault(a.get(i),0)+1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            if(entry.getValue()==1){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        int param_1 = obj.get(1);
        obj.put(3,3);
        int param_2 = obj.get(2);
        obj.put(4,4);
        int param_3 = obj.get(1);
        int param_4 = obj.get(3);
        int param_5 = obj.get(4);
    }
}
