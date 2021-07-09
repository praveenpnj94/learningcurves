//https://www.interviewbit.com/problems/roman-to-integer/
//https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/

public class Solution {
    public int romanToInt(String A) {
                // Initialize result 
        int res = 0; 
  
        for (int i=0; i<str.length(); i++) 
        { 
            // Getting value of symbol s[i] 
            int s1 = value(str.charAt(i)); 
  
            // Getting value of symbol s[i+1] 
            if (i+1 <str.length()) 
            {
                int s2 = value(str.charAt(i+1)); 
  
                // Comparing both values 
                if (s1 >= s2) 
                { 
                    // Value of current symbol is greater 
                    // or equalto the next symbol 
                    res = res + s1; 
                } 
                else
                { 
                    res = res + s2 - s1; 
                    i++; // Value of current symbol is 
                    // less than the next symbol 
                } 
            } 
            else
            { 
                res = res + s1; 
                i++; 
            } 
        } 
  
        return res; 
    }
}
