//https://www.interviewbit.com/problems/palindrome-integer/

public class Solution {
    public int isPalindrome(int A) {
        String num=String.valueOf(A);
        for(int i=0;i<num.length()/2;i++){
            if(num.charAt(i)!=num.charAt(num.length()-1-i)){
                return 0;
            }
        }
        return 1;
    }
}
