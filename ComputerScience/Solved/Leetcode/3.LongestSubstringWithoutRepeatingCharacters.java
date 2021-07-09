//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//https://www.youtube.com/watch?v=9Kc0eZBGL1U&ab_channel=Pepcoding

class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     if(s==null||s.length()==0){
    //         return 0;
    //     }
    //     int n = s.length();
    //     int maxLength =1;
    //     for(int i=0;i<n;i++){
    //         HashMap<Character,Integer> map = new HashMap<>();          
    //         for(int j=i+1;j<=n;j++){
    //             String exp = s.substring(i,j);
    //             Character c = s.charAt(j-1);
    //             map.put(c,map.getOrDefault(c,0)+1);
    //             if(isRepeating(map)){
    //                 break;
    //             }
    //             maxLength = Math.max(maxLength,j-i);
    //         }
    //     }
    //     return maxLength;
    // }
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    
    public boolean isRepeating(HashMap<Character,Integer> map){
        for(char c:map.keySet()){
            if(map.get(c)>1){
                return true;
            }
        }
        return false;
    }
}