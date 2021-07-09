//https://www.interviewbit.com/problems/diffk-ii/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] nums, int B) {
        if (B < 0) {
            return 0;
        }
        int cnt=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:map.keySet()){
            if(B==0){
                if(map.get(num)>1){
                    return 1;
                }
            }
            else{
                if(map.containsKey(num+B)){
                    return 1;
                }
            }
        }
        return 0;
    }
}
