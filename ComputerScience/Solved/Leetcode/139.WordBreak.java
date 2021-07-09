//https://leetcode.com/problems/word-break/
//https://www.youtube.com/watch?v=hLQYQ4zj0qg

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}


// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return wordBreakUtil(s,new HashSet(wordDict),0,new Boolean[s.length()]);
//     }
//     public boolean wordBreakUtil(String s, Set<String> wordDict,int start, Boolean[] dp) {
//         if(start==s.length()){
//             return true;
//         }
//         if(dp[start]!=null){
//             return dp[start];
//         }
//         for(int i=start+1;i<=s.length();i++){
//             if(wordDict.contains(s.substring(start,i)) && wordBreakUtil(s,wordDict,i,dp)){
//                 dp[start] = true;
//                 return true;
//             }
//         }
//         dp[start] = false;
//         return false;
//     }
// }

// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> wordDictSet=new HashSet(wordDict);
//         boolean[] dp = new boolean[s.length() + 1];
//         dp[0] = true;
//         for (int i = 1; i <= s.length(); i++) {
//             for (int j = 0; j < i; j++) {
//                 if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
//         return dp[s.length()];
//     }
// }

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}