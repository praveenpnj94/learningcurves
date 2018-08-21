/**
 * 
 */
package number;

import java.math.BigInteger;

/**
 * @author Praveen
 * on 08-Aug-2018 11:59:44 AM
 * 
 * Catalan Number - https://www.geeksforgeeks.org/program-nth-catalan-number/
 * https://www.youtube.com/watch?v=GlI17WaMrtw
 */
public class CatalanNumber {
    public static int getCatalanNumber(int n) {
        int res=0;
        if(n<=1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += getCatalanNumber(i) * getCatalanNumber(n - i - 1);
        }
        return res;
    }
    
    public static BigInteger getCatalanNumberUsingDynamicProgramming(int n) {
        BigInteger[] catalan=new BigInteger[n+1];
        catalan[0]=BigInteger.ONE;
        if(n>0) {
            catalan[1]=BigInteger.ONE;
            for (int i = 2; i <=n; i++) {
                catalan[i]=BigInteger.ZERO;
                for(int j=0;j<i;j++) {
                    catalan[i]=catalan[i].add(catalan[j].multiply(catalan[i-j-1]));
                }
            }           
        }
        return catalan[n];
    }
    
    public static long getCatalanNumberUsingBinaryCoefficient(int n) {
        return BinaryCoefficient.getBinaryCoefficient(2*n, n)/(n+1);
    }
}
