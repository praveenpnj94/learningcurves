/**
 * 
 */
package easy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author praveen
 * on 09-Aug-201811:29:41 PM
 */
public class OneToNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        BigInteger number=BigInteger.ZERO;
        for(int i=0;i<A.size();i++){
            number=number.add(BigDecimal.valueOf((Math.pow((double)10,(double)(A.size()-1-i)))).toBigInteger().multiply(BigInteger.valueOf(A.get(i))));
        }
        number=number.add(BigInteger.ONE);
        String t=number.toString();
        ArrayList<Integer> mod=new ArrayList<Integer>();
        for(int j=0;j<t.length();j++){
            mod.add(t.charAt(j) - '0');
        }
        return mod;
    }
    
	public static ArrayList<Integer> plusOneIB(ArrayList<Integer> a) {
	    int i = 0;
        //remove zeroes at the front
        while (i < a.size() - 1 && a.get(i) == 0) {
            a.remove(i);
        }

        int carry = 1;
        int sum;
        for (i = a.size() - 1; i >= 0; i--) {
            sum = a.get(i) + carry;
            a.set(i, sum % 10);
            carry = sum / 10;
            // no need of further processing if carry is zero
            if (carry == 0) {
                break;
            }
        }
        // if carry is still left
        if (carry != 0) {
            a.add(0, carry);
        }
        return a; 
	}
}
