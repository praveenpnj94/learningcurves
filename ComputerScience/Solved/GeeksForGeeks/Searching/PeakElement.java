//https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/


/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class Peak
{
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] a,int n)
    {
       return new Peak().findPeakUtil(a,0,n-1,n);
    }
    int findPeakUtil(int arr[], int low, int high, int n) 
    { 
        // Find index of middle element 
        int mid = low + (high - low)/2;  /* (low + high)/2 */
  
        // Compare middle element with its neighbours (if neighbours 
        // exist) 
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || 
             arr[mid+1] <= arr[mid])) 
            return mid; 
  
        // If middle element is not peak and its left neighbor is 
        // greater than it,then left half must have a peak element 
        else if (mid > 0 && arr[mid-1] > arr[mid]) 
            return findPeakUtil(arr, low, (mid -1), n); 
  
        // If middle element is not peak and its right neighbor 
        // is greater than it, then right half must have a peak 
        // element 
        else return findPeakUtil(arr, (mid + 1), high, n); 
    }
}