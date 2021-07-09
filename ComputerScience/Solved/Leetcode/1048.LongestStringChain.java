//https://leetcode.com/problems/longest-string-chain/

class Solution {
    //     public int longestStrChain(String[] words) {
    //         if(words==null || words.length==0){
    //             return 0;
    //         }
    //         int n = words.length;
    //         Arrays.sort(words, new ChainComparator());
            
    //         int[] dp = new int[n];
            
    //         Arrays.fill(dp,1);
    //         int max = 1;
            
    //         for(int i=0;i<n;i++){
    //             for(int j=0;j<i;j++){
    //                 if(isPredecessor(words[j],words[i])){
    //                     dp[i]=Math.max(dp[i],1+dp[j]);
    //                 }
    //             }
    //             max=Math.max(max,dp[i]);
    //         }
            
    //         return max;
    //     }
        
    //     public boolean isPredecessor(String word1, String word2){        
    //         if(word2.length()-word1.length()!=1){
    //             return false;
    //         }
    //         else{
    //             return lcs(word1,word2)==word1.length();
    //         }        
    //     }
        
    //     public int lcs(String a, String b){  
    //         if(a==null||b==null){
    //             return 0;
    //         }    
    //         int[][] dp = new int[a.length() + 1][b.length() + 1];        
    //         for(int i=1;i<=a.length();i++){
    //             for(int j=1;j<=b.length();j++){
    //                 if(a.charAt(i-1)==b.charAt(j-1)){
    //                     dp[i][j]=dp[i-1][j-1]+1;
    //                 }
    //                 else{
    //                     dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
    //                 }
    //             }
    //         }
    //         return dp[a.length()][b.length()];
    //     }
        
        public int longestStrChain(String[] words) {
            Map<String, Integer> dp = new HashMap<>();
            Arrays.sort(words, (a, b)->a.length() - b.length());
            int res = 0;
            for (String word : words) {
                int best = 0;
                for (int i = 0; i < word.length(); ++i) {
                    String prev = word.substring(0, i) + word.substring(i + 1);
                    best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
                }
                dp.put(word, best);
                res = Math.max(res, best);
            }
            return res;
        }
    }
    class ChainComparator implements Comparator<String>{
        public int compare(String a, String b){
            return a.length()-b.length();
        }
    }