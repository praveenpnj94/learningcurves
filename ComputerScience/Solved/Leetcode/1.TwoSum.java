//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[0];
        }
        Map<Integer,Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(m.containsKey(diff)){
                res[0] = m.get(diff);
                res[1] = i;
                break;
            }
            else{
                m.put(nums[i],i);
            }
        }
        return res;
    }
}