//https://www.interviewbit.com/problems/longest-increasing-subsequence/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max =1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(A[i]>A[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

//https://www.youtube.com/watch?v=nf3YG4CnTbg
//http://www.algorithmsandme.com/longest-increasing-subsequence-in-onlogn/

class Solution {       
        
        public int search(int a[],int n,int x)
        {
            if(x <= a[0]) return 0;
            if(x > a[n-1]) return n - 1;
            int l = 0, h = n - 1, m = -1;
            while(l <= h)
            {
                m = (l + h)/2;
                if(a[m] == x) return m;
                if(x < a[m]) h = m - 1;
                else l = m + 1;
            }
            return l;
        }
        
        public int lengthOfLIS(int[] a) {
            
            if(a.length == 0) return 0;
            int last[] = new int[a.length];
            int len = 1;
            last[0] = a[0];
            
            for(int i=1;i<a.length;i++)
            {
                if(a[i] > last[len-1]) last[len++] = a[i];
                else {
                    int idx = search(last,len,a[i]);
                    last[idx] = a[i];
                }
    
            }
            
            return len;
        }
    }
