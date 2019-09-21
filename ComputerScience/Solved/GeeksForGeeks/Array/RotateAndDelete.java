//https://practice.geeksforgeeks.org/problems/rotate-and-delete/0/?track=PC-W2-A&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0){
		    int length = in.nextInt();
		    ArrayList<Integer> list = new ArrayList<Integer>(); 

		    for(int i=0;i<length;i++){
		        list.add(in.nextInt());
		    }
		    int times=1;
		    
		    while(list.size() != 1){
                rotate(list);
		        remove(list,times);
		        times++;
		    }
		    System.out.println(list.get(0));
		}
	}
	
	public static void rotate(ArrayList<Integer> list){
	    list.add(0,list.get(list.size()-1));
	    list.remove(list.size()-1);
	}
	public static void remove(ArrayList<Integer> list,int k){
	    if(k > list.size()){
	        list.remove(0);
	    }
	    else{
	        list.remove(list.size() - k);
	    }
	}
}