//https://www.geeksforgeeks.org/calculate-sum-of-all-numbers-present-in-a-string/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String word = br.readLine();
		    System.out.println(sumInString(word));
		}
	}
	public static int sumInString(String word){
        int sum =0;
        char[] wordArray = word.toCharArray();
        String numString ="";
        for(int i=0;i<wordArray.length;i++){
            if(Character.isDigit(wordArray[i])){
                numString+=Character.toString(wordArray[i]);
                if(!numString.equals("") && i==wordArray.length-1){
                    sum+=Integer.parseInt(numString);
                }
            }
            else{
                if(!numString.equals("")){
                    sum+=Integer.parseInt(numString);
                }
                numString = "";
            }
        }
        return sum;
	}
}