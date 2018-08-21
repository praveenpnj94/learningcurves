// Java program to find length of the longest
// subarray with non-negative numbers.

//https://www.geeksforgeeks.org/longest-subarray-non-negative-integers/

class GFG 
{

	// Function that returns the longest
	// subarray of non-negative integers 
	static int longestSubarry(int arr[], int n)
	{
		// Initialize result
		int res = 0; 
		
		// Traverse array
		for (int i = 0; i < n; i++)
		{
			// Count of current non-
			// negative integers
			int curr_count = 0;
			while (i < n && arr[i] >= 0)
			{
				curr_count++;
				i++;
			}
		
			// Update result if required.
			res = Math.max(res, curr_count);
		}
		
		return res;
	}
	
	// Driver code
	public static void main(String[] args)
	{
		int arr[] = {1, 0, 4, 0, 1, -1,
						-1, 0, 0, 1, 0};
		int n = arr.length;
		System.out.println(longestSubarry(arr, n));
	}
}

// This code is contributed by prerna saini.
