//https://www.interviewbit.com/problems/atoi/

public class Solution {
	public int atoi(final String A) {
	    int idx;
	    long num;
	    int n = A.length();
	    boolean sign = true;
	    
	    idx = 0;
	    
	    while (idx < n && A.charAt(idx) == ' ')
	        idx++;
	        
	    if (idx == n)
	        return 0;
	    
	    if (A.charAt(idx) == '-') {
	        sign = false;
	        idx++;
	    } else if (A.charAt(idx) == '+') {
	        idx++;
	    }
	    
	    num = 0;
	    
	    while (idx < n && A.charAt(idx) >= '0' && A.charAt(idx) <= '9') {
	        
	        num = Math.abs(num);
	        num = num * 10 + A.charAt(idx) - '0';
	        
	        if (!sign)
	            num = -num;
	        
	        if (num > Integer.MAX_VALUE)
	            return Integer.MAX_VALUE;
	            
	        else if (num < Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	            
	        idx++;
	            

	    }
	    
	    return (int) num;
	    
	}

	/*
	public int atoi(String str) {
	if (str == null || str.length() < 1)
		return 0;
 
	// trim white spaces
	str = str.trim();
 
	char flag = '+';
 
	// check negative or positive
	int i = 0;
	if (str.charAt(0) == '-') {
		flag = '-';
		i++;
	} else if (str.charAt(0) == '+') {
		i++;
	}
	// use double to store result
	double result = 0;
 
	// calculate value
	while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		result = result * 10 + (str.charAt(i) - '0');
		i++;
	}
 
	if (flag == '-')
		result = -result;
 
	// handle max and min
	if (result > Integer.MAX_VALUE)
		return Integer.MAX_VALUE;
 
	if (result < Integer.MIN_VALUE)
		return Integer.MIN_VALUE;
 
	return (int) result;
}
	*/
}
