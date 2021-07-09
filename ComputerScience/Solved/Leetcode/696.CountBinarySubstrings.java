//https://leetcode.com/problems/count-binary-substrings/

class Solution {
    public int countBinarySubstrings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int res =0;
        int prev =0;
        int curr =1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
            }
            else{
                res+=Math.min(curr,prev);
                prev = curr;
                curr=1;
            }
        }
        return res+Math.min(curr,prev);
    }
}