//https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
//https://www.youtube.com/watch?list=TLGG2H79FpIeZL4yMjAxMjAyMQ&v=jdfpGSSyN2I&feature=emb_title&ab_channel=Pepcoding

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[] lis = lis(nums);
        int[] lds = lds(nums);
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(lis[i]+lds[i]-1,max);
        }
        return max;
    }
    
    public int[] lis(int[] nums){
        if(nums==null||nums.length==0){
            int[] a = {};
            return a;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
    
    public int[] lds(int[] nums){
        if(nums==null||nums.length==0){
            int[] a = {};
            return a;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
}