//https://www.interviewbit.com/problems/number-of-1-bits/
//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//https://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/

public class Solution {
    public int numSetBits(long n) {
        int count = 0; 
        while (n > 0) 
        { 
            n &= (n - 1) ; 
            count++; 
        } 
        return count; 
    }
}