//https://math.stackexchange.com/questions/1669379/all-possible-combinations-of-the-black-and-white-knight-on-8x8-chess-board-whic


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class GFG {
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
	int t;
    BigInteger m, n, p,q;
    BigInteger one = new BigInteger("1");
    BigInteger two = new BigInteger("2");
    BigInteger four = new BigInteger("4");
    t = sc.nextInt();
    while (t-- > 0) {
        m = sc.nextBigInteger();
        n = sc.nextBigInteger();
        p = m.multiply(n);
        p = p.multiply(p.subtract(one));
        if (n.equals(one) || m.equals(one))
        	 System.out.println(p);
        else{
        	q = m.subtract(two).multiply(n.subtract(one)).add(m.subtract(one).multiply(n.subtract(two)));
        	q = q.multiply(four);
        	p = p.subtract(q);
        	System.out.println(p);
        }
    }
sc.close();
}
}