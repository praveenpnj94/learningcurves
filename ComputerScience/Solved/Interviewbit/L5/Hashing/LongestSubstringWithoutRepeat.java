//https://www.interviewbit.com/problems/longest-substring-without-repeat/

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int i=0;
        int j=0;
        HashSet<Character> hs = new HashSet<Character>();
        int n = A.length();
        int ans =1;
        while(i<n && j<n){
            char c = A.charAt(i);
            if(!hs.contains(c)){
                hs.add(c);
                i++;
                ans=Math.max(ans,i-j);
            }
            else{
                hs.remove(A.charAt(j++));
            }
        }
        return ans;
    }
}
