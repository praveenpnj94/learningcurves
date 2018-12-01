//https://www.interviewbit.com/problems/largest-coprime-divisor/
//https://www.geeksforgeeks.org/largest-number-divides-x-co-prime-y/

public class Solution {
    public int cpFact(int A, int B) {
        while (gcd(A, B) != 1) { 
            A = A / gcd(A, B); 
        } 
        return A; 
    }
    public int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}
