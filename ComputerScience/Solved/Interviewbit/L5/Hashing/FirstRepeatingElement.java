//https://www.interviewbit.com/problems/first-repeating-element/

public class Solution {
    public int solve(int[] A) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int num:A){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int n:map.keySet()){
            if(map.get(n)>1){
                return n;
            }
        }
        return -1;
    }
}
