//https://leetcode.com/problems/largest-divisible-subset/

//https://www.youtube.com/watch?v=Wv6DlL0Sawg&ab_channel=TECHDOSE

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> al = new ArrayList<>();
        if(nums==null||nums.length==0){
            return al;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    max = Math.max(max,dp[i]);
                }
            }
        }
        
        int prev=-1;
        for(int i=n-1;i>=0;i--){
            if(dp[i]==max && (prev%nums[i]==0 || prev==-1)){
                al.add(nums[i]);
                max-=1;
                prev=nums[i];
            }
        }
        
        return al;
    }
}