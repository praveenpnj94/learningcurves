//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
//https://leetcode.com/problems/contiguous-array/
//https://www.youtube.com/watch?v=9ZyLjjk536U

class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        // for(int i=0;i<nums.length;i++){
        //     int currLength = 0;
        //     int zeroLength = 0;
        //     int oneLength = 0;
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[j]==0){
        //             zeroLength++;
        //         }
        //         else{
        //             oneLength++;
        //         }
        //         if(zeroLength==oneLength){
        //             currLength = j-i+1;
        //         }
        //     }
        //     maxLength = Math.max(maxLength,currLength);
        // }
        // return maxLength;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }
            else{
                sum+=1;
            }
            if(sum ==0 && i+1>maxLength){
                maxLength = i+1;
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            else{
                int oldIdx = map.get(sum);
                maxLength = Math.max(i-oldIdx,maxLength);
            }
        }
        return maxLength;
    }
}