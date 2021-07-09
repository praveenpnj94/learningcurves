//https://leetcode.com/problems/russian-doll-envelopes/
//https://www.thealgorists.com/Algo/DynamicProgramming/LongestIncreasingSubsequence/RussianDollEnvelopes

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        if(m==0){
            return 0;
        }
        int n = envelopes[0].length;
        if(n==0){
            return 0;
        }
        Envelope[] env = new Envelope[m];
        int idx=0;
        for(int[] e: envelopes){
            Envelope envelope = new Envelope(e[0],e[1]);
            env[idx]=envelope;
            idx++;
        }
        Arrays.sort(env,new EnvelopeComparator());       
        int[] dp = new int[m];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if(env[j].w<env[i].w && env[j].h<env[i].h){
                    dp[i]=Math.max(dp[i],1+dp[j]);                 
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
class Envelope{
    int w;
    int h;  
    
    Envelope(int w, int h){
        this.w = w;
        this.h = h;
    }
}
class EnvelopeComparator implements Comparator<Envelope>{
    public int compare(Envelope env1,Envelope env2){
        return env1.w- env2.w;
    }
}