//https://www.geeksforgeeks.org/stock-buy-sell/
//https://www.youtube.com/watch?v=blUwDD6JYaE


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); 
		    int[] a = new int[n];
		    String[] arr = br.readLine().split(" ");
		    for(int i=0;i<arr.length;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    stockBuySell(a,n);
		    System.out.println();
		}
    }
    
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0){
                return 0;
            }
            int profit = 0;
            for(int i=0;i<prices.length-1;i++){
                if(prices[i+1]>prices[i]){
                    profit+=prices[i+1]-prices[i];
                }
            }
            return profit;
        }
    }
	
	public static void stockBuySell(int price[], int n)
    {
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima

            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0)
            System.out.print("No Profit");
        else
            for (int j = 0; j < count; j++)
                System.out.print("(" + sol.get(j).buy
                        + " "
                        + sol.get(j).sell+") ");

        return;
    }
}

class Interval {
    int buy, sell;
}