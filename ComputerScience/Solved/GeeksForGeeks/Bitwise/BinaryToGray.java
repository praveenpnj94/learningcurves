//https://www.geeksforgeeks.org/gray-to-binary-and-binary-to-gray-conversion/

import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
		    System.out.println(getGrayNumber(Integer.parseInt(br.readLine())));
		}
	}
	public static int getGrayNumber(int n){
	    String binary = Integer.toBinaryString(n);
	    String grayCode = "";
	    grayCode+=Character.toString(binary.charAt(0));
	    for(int i =1 ;i<binary.length();i++){
	        int l = Integer.parseInt(Character.toString(binary.charAt(i)));
	        int m=  Integer.parseInt(Character.toString(binary.charAt(i-1)));
	        grayCode+= l^m;
	    }
	    int res =0 ;
	    for(int j=0;j<grayCode.length();j++){
	        int a = Integer.parseInt(Character.toString(grayCode.charAt(j)));
	        res+= a*(int)Math.pow(2,grayCode.length()-j-1);
	    }
	    return res;
	    
	}
}