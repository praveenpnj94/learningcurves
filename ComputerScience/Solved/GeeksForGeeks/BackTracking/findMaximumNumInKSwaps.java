//https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
   public static String max="0";
     public static void findMaximumNum(String str, int k) 
{ 
   
    if(k == 0) 
        return; 
  
    int n = str.length(); 
      
    // consider every digit 
    for (int i = 0; i < n - 1; i++) 
    { 
       
        // and compare it with all digits after it 
        for (int j = i + 1; j < n; j++) 
        { 
             
            if (str.charAt(i) < str.charAt(j)) 
            { 
                // swap str[i] with str[j] 
                //swap(str[i], str[j]); 
                char strArray[] = str.toCharArray();
                     char temp = strArray[i];
				strArray[i] = strArray[j];
				strArray[j] = temp;
				
				str = String.valueOf(strArray);  
                 
                
                if (str.compareTo( max)>0) {
                    max = str; }
  
                // recurse of the other k - 1 swaps 
                findMaximumNum(str, k - 1); 
  
                 
                     temp = strArray[i];
				strArray[i] = strArray[j];
				strArray[j] = temp;
				
				str = String.valueOf(strArray);
                
            } 
        } 
    } 
} 
	public static void main (String[] args)
	 {
	  Scanner sc=new Scanner(System.in);
	  int tc=sc.nextInt();
	  while(tc-->0)
	  {
	      int k=sc.nextInt();
	      max="0";
	      String s;
	      s=sc.next();
	       
	      findMaximumNum(s,k);
	      if(max.equals("0"))
	      System.out.println(s);
	      else
	      System.out.println(max);
	  }
	 }
}