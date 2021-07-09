//https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1
//https://www.youtube.com/watch?v=hgA4xxlVvfQ&ab_channel=TusharRoy-CodingMadeSimple

public class OptimalTreeSearch {

    public int minCostRec(int input[],int freq[]){
        
        return minCostRec(input,freq,0,input.length-1,1);
    }
    
    private int minCostRec(int input[],int freq[],int low,int high,int level){
        if(low > high){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=low; i <= high; i++){
            int val = minCostRec(input,freq,low,i-1,level+1) + 
                    minCostRec(input,freq,i+1,high,level+1)
                    + level*freq[i];
            if(val < min){
                min = val;
            }
        }
        return min;
    }
    
    public int minCost(int input[], int freq[]){
        int T[][] = new int[input.length][input.length];
        
        for(int i=0; i < T.length; i++){
            T[i][i] = freq[i];
        }
        
        for(int l = 2; l <= input.length; l++){
            for(int i=0; i <= input.length-l; i++){
                int j = i + l -1;
                T[i][j] = Integer.MAX_VALUE;
                int sum = getSum(freq, i, j);
                
                for(int k=i; k <= j; k++){
                     int val = sum + (k-1 < i ? 0 : T[i][k-1]) +
                            (k+1 > j ? 0 : T[k+1][j]) ;
                     if(val < T[i][j]){
                         T[i][j] = val;
                     }
                }
            }
        }
        return T[0][input.length-1];
    }
    
    private int getSum(int freq[], int i, int j){
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
 
    
    public static void main(String args[]){
        int input[] = {10,12,20,35,46};
        int freq[] = {34,8,50,21,16};
        OptimalTreeSearch ots = new OptimalTreeSearch();
        System.out.println(ots.minCost(input, freq));
        System.out.println(ots.minCostRec(input, freq));
    }
}


// A naive recursive implementation of optimal binary 
// search tree problem 
public class GFG 
{ 
	// A recursive function to calculate cost of 
		// optimal binary search tree 
	static int optCost(int freq[], int i, int j) 
	{ 
	// Base cases 
	if (j < i)	 // no elements in this subarray 
		return 0; 
	if (j == i)	 // one element in this subarray 
		return freq[i]; 
	
	// Get sum of freq[i], freq[i+1], ... freq[j] 
	int fsum = sum(freq, i, j); 
	
	// Initialize minimum value 
	int min = Integer.MAX_VALUE; 
	
	// One by one consider all elements as root and 
		// recursively find cost of the BST, compare the 
		// cost with min and update min if needed 
	for (int r = i; r <= j; ++r) 
	{ 
		int cost = optCost(freq, i, r-1) + 
						optCost(freq, r+1, j); 
		if (cost < min) 
			min = cost; 
	} 
	
	// Return minimum value 
	return min + fsum; 
	} 
	
	// The main function that calculates minimum cost of 
		// a Binary Search Tree. It mainly uses optCost() to 
		// find the optimal cost. 
	static int optimalSearchTree(int keys[], int freq[], int n) 
	{ 
		// Here array keys[] is assumed to be sorted in 
			// increasing order. If keys[] is not sorted, then 
			// add code to sort keys, and rearrange freq[] 
			// accordingly. 
		return optCost(freq, 0, n-1); 
	} 
	
	// A utility function to get sum of array elements 
		// freq[i] to freq[j] 
	static int sum(int freq[], int i, int j) 
	{ 
		int s = 0; 
		for (int k = i; k <=j; k++) 
		s += freq[k]; 
		return s; 
	} 
	
	// Driver code 
	public static void main(String[] args) { 
		int keys[] = {10, 12, 20}; 
		int freq[] = {34, 8, 50}; 
		int n = keys.length; 
		System.out.println("Cost of Optimal BST is " + 
						optimalSearchTree(keys, freq, n)); 
	} 
} 
// This code is contributed by Sumit Ghosh 



class Solution
{
    static int optimalSearchTree(int input[], int freq[], int n)
    {
        int[][] dp = new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return helper(freq,0,n-1,dp);
    }
    
    static int helper(int[] freq, int i, int j,int[][] dp){
        
        if(i>j){
            return 0;
        }
        
        if(i==j){
            return dp[i][j]=freq[i];
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int sum = getSum(freq,i,j);
        int val = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            val = Math.min((helper(freq,i,k-1,dp)+helper(freq,k+1,j,dp)),val);
        }
        int res = val+sum;
        return dp[i][j]=res;
        
    }
    
    private static int getSum(int freq[], int i, int j){
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
}
