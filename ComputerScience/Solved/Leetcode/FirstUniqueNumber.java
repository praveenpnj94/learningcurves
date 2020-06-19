//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/

//https://leetcode.com/discuss/interview-question/601965/First-Unique-Number-with-explanation

class FirstUnique {
    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    public FirstUnique(int[] nums) {
         map = new LinkedHashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) == 1) queue.offer(key);
        }       
    }
    
    public int showFirstUnique() {
        if (queue.isEmpty()) return -1;
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) queue.poll();
        return queue.isEmpty() ? -1 : queue.peek();        
    }
    
    public void add(int value) {
        if (!map.containsKey(value)) queue.offer(value);//unique? then add to queue
        map.put(value, map.getOrDefault(value, 0) + 1);        
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
class FirstUnique {

    private Queue<Integer> queue = new ArrayDeque<>();
    private Map<Integer, Boolean> isUnique = new HashMap<>();
  
    public FirstUnique(int[] nums) {
      for (int num : nums) {
        // Notice that we're calling the "add" method of FirstUnique; not of the queue. 
        this.add(num);
      }
    }
  
    public int showFirstUnique() {
      // We need to start by "cleaning" the queue of any non-uniques at the start.
      // Note that we know that if a value is in the queue, then it is also in
      // isUnique, as the implementation of add() guarantees this.
      while (!queue.isEmpty() && !isUnique.get(queue.peek())) {
        queue.remove();
      }
      // Check if there is still a value left in the queue. There might be no uniques.
      if (!queue.isEmpty()) {
        return queue.peek(); // We don't want to actually *remove* the value.
      }
      return -1;
    }
  
    public void add(int value) {
      // Case 1: We need to add the number to the queue and mark it as unique. 
      if (!isUnique.containsKey(value)) {
        isUnique.put(value, true);
        queue.add(value);
      // Case 2 and 3: We need to mark the number as no longer unique.
      } else {
        isUnique.put(value, false);
      }
    }
  }