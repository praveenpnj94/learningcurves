//https://www.interviewbit.com/problems/binary-representation/

public class Solution {
	public String findDigitsInBinary(int a) {
	    if(a <= 0 ){
	        return "0";
	    }
	    
	    StringBuilder ans = new StringBuilder();
	    while(a > 0){
	        ans.append(a % 2);      //we have to append remainder to ans
	        a = a / 2;
	    }
	    
	    return ans.reverse().toString();   //to fetch the binary equivalent
	}
}