//https://www.interviewbit.com/problems/2-sum/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] twoSum(final int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[0];
        }
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(m.containsKey(diff)){
                int[] res = new int[2];
                res[0] = m.get(diff)+1;
                res[1] = i+1;
                return res;
            }
            else{
                if(!m.containsKey(nums[i])){
                    m.put(nums[i],i);
                }
                
            }
        }
        return new int[0];
    }
}
