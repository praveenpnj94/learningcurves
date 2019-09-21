//https://practice.geeksforgeeks.org/problems/gray-to-binary-equivalent/0/?track=PC-W1-BM&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    System.out.println(getBinaryNumber(Integer.parseInt(br.readLine())));
		}
	}
	public static int getBinaryNumber(int n){
	    String binary = Integer.toBinaryString(n);
	    String binaryCode = "";
	    binaryCode+=Character.toString(binary.charAt(0));
	    for(int i =1 ;i<binary.length();i++){
	        String c =  binary.charAt(i)=='0'?Character.toString(binaryCode.charAt(i-1)):flip(binaryCode.charAt(i-1));
	        binaryCode+=c;
	    }
	    int res =0 ;
	    for(int j=0;j<binaryCode.length();j++){
	        int a = Integer.parseInt(Character.toString(binaryCode.charAt(j)));
	        res+= a*(int)Math.pow(2,binaryCode.length()-j-1);
	    }
	    return res;
	}
	public static String flip(char c){
	    return (c == '0') ? "1" : "0";
	}
}