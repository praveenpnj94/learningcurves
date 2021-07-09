//https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<=1){
            return false;
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int n:nums){
            hs.add(n);
        }
        
        if(hs.size()==nums.length){
            return false;
        }
        
        return true;
    }
}