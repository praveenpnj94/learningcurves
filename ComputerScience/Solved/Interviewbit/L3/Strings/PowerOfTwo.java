//https://www.interviewbit.com/problems/power-of-2/


import java.math.BigInteger;
public class Solution {
    public int power(String A) {
        BigInteger num = new BigInteger(A);
        while(num.compareTo(BigInteger.valueOf(0))>0){
            if(num.compareTo(BigInteger.valueOf(2))==0){
                return 1;
            }
            BigInteger rem= num.mod(BigInteger.valueOf(2));
            if(rem.compareTo(BigInteger.valueOf(0))>0){
                return 0;
            }
            num = num.divide(BigInteger.valueOf(2));
        }
        return 1;
    }
}
