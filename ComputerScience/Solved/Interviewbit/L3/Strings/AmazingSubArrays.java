//https://www.interviewbit.com/problems/amazing-subarrays/
public class Solution {
    public int solve(String A) {
        int count =0;
        for(int i =0;iA.length();i++){
            if(isVowel(A.charAt(i))){
                count = count + A.length() - i;
            }
        }
        return count%10003;
    }
    
    public boolean isVowel(char c){
        if(c == 'a'c == 'e'c == 'i'c == 'o'c == 'u'){
            return true;
        }
        else if(c == 'A'c == 'E'c == 'I'c == 'O'c == 'U'){
            return true;
        }
        return false;
    }
}