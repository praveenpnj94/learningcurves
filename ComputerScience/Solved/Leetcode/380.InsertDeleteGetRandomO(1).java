//https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {

    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> al;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        al = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.get(val)!=null){
            return false;
        }
        int pos = al.size();
        al.add(val);
        map.put(val,pos);
        return true;        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    if (! map.containsKey(val)) return false;

    // move the last element to the place idx of the element to delete
    int lastElement = al.get(al.size() - 1);
    int idx = map.get(val);
    al.set(idx, lastElement);
    map.put(lastElement, idx);
    // delete the last element
    al.remove(al.size() - 1);
    map.remove(val);
    return true;
    }
    
    private void swap(ArrayList<Integer> al,int i , int j){
        int temp = al.get(i);
        al.set(i,al.get(j));
        al.set(j,temp);    
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rd = new Random();
        int i = rd.nextInt(al.size());
        return al.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */