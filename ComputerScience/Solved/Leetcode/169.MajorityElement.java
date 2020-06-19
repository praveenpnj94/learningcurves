//https://leetcode.com/problems/majority-element/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
//https://www.youtube.com/watch?v=n5QY3x_GNDg

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        LinkedHashMap<Integer,Integer> m = new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: m.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}