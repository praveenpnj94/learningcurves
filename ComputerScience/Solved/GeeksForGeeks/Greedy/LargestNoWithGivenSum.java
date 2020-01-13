//https://www.geeksforgeeks.org/find-the-largest-number-with-given-number-of-digits-and-sum-of-digits/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] dim = br.readLine().trim().split(" ");
            int n = Integer.parseInt(dim[0]);
            int s = Integer.parseInt(dim[1]);
            System.out.println(largestNoWithGivenSum(n,s));
        }
    }
    public static String largestNoWithGivenSum(int n,int s){
        if(s>9*n){
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            if(s>=9){
                sb.append("9");
                s= s-9;
            }
            else{
                Integer temp = s;
                sb.append(temp.toString());
                s=0;
            }
        }
        return sb.toString();
    }
}