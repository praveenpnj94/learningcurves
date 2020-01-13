//https://www.geeksforgeeks.org/finding-n-th-number-made-prime-digits/

// Java program to find n-th number with
// prime digits 2, 3 and 7
import java.util.*;
class GFG{
    static String nthprimedigitsnumber(int number)
    {
        int rem;
        String num="";
        while (number>0) {
            // remainder for check element position
            rem = number % 4;
            switch (rem) {

                // if number is 1st position in tree
                case 1:
                    num+='2';
                    break;

                // if number is 2nd position in tree
                case 2:
                    num+='3';
                    break;

                // if number is 3rd position in tree
                case 3:
                    num+='5';
                    break;

                // if number is 4th position in tree
                case 0:
                    num+='7';
                    break;
            }

            number = number / 4;
        }

        return new StringBuilder(num).reverse().toString();
    }

    // Driver code
    public static void main(String[] args)
    {
        int number = 21;
        System.out.println(nthprimedigitsnumber(10));
        System.out.println(nthprimedigitsnumber(21));
    }

    public static int nthNumberMadeOfPrimeDigits(int n){
	    int j=0;
	    Integer k = 2;
	    while(j<n){
	        if(containsPrimeDigits(k.toString())){
	            j++;
	        }
	        k++;
	    }
	    return k-1;
	}
	public static boolean containsPrimeDigits(String k) {
	    HashSet<Character> s = new HashSet<Character>();
	    s.add('2');
	    s.add('3');
	    s.add('5');
	    s.add('7');
	    for(int i=0;i<k.length();i++){
	        if(!s.contains(k.charAt(i))){
	            return false;
	        }
	    }
	    return true;
	}
}
// This code is contributed by mits
