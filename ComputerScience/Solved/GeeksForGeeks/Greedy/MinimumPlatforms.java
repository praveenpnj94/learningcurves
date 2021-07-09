//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station-set-2-map-based-approach/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] arrival = br.readLine().trim().split(" ");
		    String[] arrivalCopy =new String[n];
		    int j=0;
		    for(int i=0;i<arrival.length;i++){
		        if(!arrival[i].equals("")){
		            arrivalCopy[j] = arrival[i];
		            j++;
		        }
		    }
		    
		    String[] departure = br.readLine().trim().split(" ");
		    TrainInfo[] a = new TrainInfo[n];
		    TrainInfo[] d = new TrainInfo[n];
		    for(int i=0;i<arrivalCopy.length;i++){
		        TrainInfo tr = new TrainInfo(0,Integer.parseInt(arrivalCopy[i]));
		        a[i] = tr;
		        if(Integer.parseInt(departure[i])<Integer.parseInt(arrivalCopy[i])){
		            TrainInfo s = new TrainInfo(0,Integer.parseInt(departure[i])+2400);
		            d[i] = s;		            
		        }
		        else{
		            TrainInfo s = new TrainInfo(0,Integer.parseInt(departure[i]));
		            d[i] = s;		            
		        }
		    }
		    System.out.println(minimumPlatforms(a,d,n));
		}
	}
	public static int minimumPlatforms(TrainInfo[] a, TrainInfo[] d,int n){
	    Arrays.sort(a);
	    Arrays.sort(d);
	    int i =1;
	    int j=0;
	    int platformNeeded =1;
	    int result = 1;
	    while(i<n && j<n){
	        if((a[i].time<d[j].time && a[i].id!=d[j].id)||(a[i].time<=d[j].time && a[i].id==d[j].id)){
	            platformNeeded++;
	            i++;
	            result = Math.max(result,platformNeeded);
	        }
	        else{
	            platformNeeded--;
	            j++;
	        }
	        
	    }
	    return result;
	}
}
class TrainInfo implements Comparable<TrainInfo>{
    int time;
    int id;
    TrainInfo(int id , int time){
        this.id = id;
        this.time = time;
    }
    
    public int compareTo(TrainInfo info) {
        return this.time - info.time;
    }
}



class GFG { 

	// Returns minimum number of platforms reqquired 
	static int findPlatform(int arr[], int dep[], int n) 
	{ 
		// Sort arrival and departure arrays 
		Arrays.sort(arr); 
		Arrays.sort(dep); 

		// plat_needed indicates number of platforms 
		// needed at a time 
		int plat_needed = 1, result = 1; 
		int i = 1, j = 0; 

		// Similar to merge in merge sort to process 
		// all events in sorted order 
		while (i < n && j < n) { 

			// If next event in sorted order is arrival, 
			// increment count of platforms needed 
			if (arr[i] <= dep[j]) { 
				plat_needed++; 
				i++; 
			} 

			// Else decrement count of platforms needed 
			else if (arr[i] > dep[j]) { 
				plat_needed--; 
				j++; 
			} 

			// Update result if needed 
			if (plat_needed > result) 
				result = plat_needed; 
		} 

		return result; 
	} 

	// Driver program to test methods of graph class 
	public static void main(String[] args) 
	{ 
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 }; 
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 }; 
		int n = arr.length; 
		System.out.println("Minimum Number of Platforms Required = "
						+ findPlatform(arr, dep, n)); 
	} 
} 
