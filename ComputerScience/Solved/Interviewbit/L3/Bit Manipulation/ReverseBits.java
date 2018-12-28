//https://www.geeksforgeeks.org/reverse-actual-bits-given-number/
//https://www.interviewbit.com/problems/reverse-bits/
public class Solution {
    public long reverse(long a) {
        long result = 0;
        int i = 31;
        while(a > 0){
            result += (a % 2) * Math.pow(2, i);
            i--;                        
            a = a/2;
        }
        return result;
    }
}
