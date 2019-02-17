//https://www.interviewbit.com/problems/integer-to-roman/
//https://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/

public class Solution {
    public String intToRoman(int num) {
        String m[] = {"", "M", "MM", "MMM"}; 
        String c[] = {"", "C", "CC", "CCC", "CD", "D",  
                            "DC", "DCC", "DCCC", "CM"}; 
        String x[] = {"", "X", "XX", "XXX", "XL", "L",  
                            "LX", "LXX", "LXXX", "XC"}; 
        String i[] = {"", "I", "II", "III", "IV", "V",  
                            "VI", "VII", "VIII", "IX"}; 
              
        // Converting to roman 
        String thousands = m[num/1000]; 
        String hundereds = c[(num%1000)/100]; 
        String tens = x[(num%100)/10]; 
        String ones = i[num%10]; 
              
        String ans = thousands + hundereds + tens + ones; 
              
        return ans; 
    }
    
}
