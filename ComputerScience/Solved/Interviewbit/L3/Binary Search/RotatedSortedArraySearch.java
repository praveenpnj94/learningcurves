//https://www.interviewbit.com/problems/rotated-sorted-array-search/
//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> arr, int key) {
        int n = arr.size();
       int pivot = findPivot(arr, 0, n-1); 
        
       // If we didn't find a pivot, then  
       // array is not rotated at all 
       if (pivot == -1) 
           return binarySearch(arr, 0, n-1, key); 
        
       // If we found a pivot, then first  
       // compare with pivot and then 
       // search in two subarrays around pivot 
       if (arr.get(pivot) == key) 
           return pivot; 
       if (arr.get(0) <= key) 
           return binarySearch(arr, 0, pivot-1, key); 
       return binarySearch(arr, pivot+1, n-1, key); 
    }
    
    int findPivot(final List<Integer> arr, int low, int high) 
    { 
       // base cases 
       if (high < low)   
            return -1; 
       if (high == low)  
            return low; 
         
       /* low + (high - low)/2; */
       int mid = (low + high)/2;    
       if (mid < high && arr.get(mid) > arr.get(mid + 1)) 
           return mid; 
       if (mid > low && arr.get(mid) < arr.get(mid-1)) 
           return (mid-1); 
       if (arr.get(low) >= arr.get(mid)) 
           return findPivot(arr, low, mid-1); 
       return findPivot(arr, mid + 1, high); 
    }
    
    int binarySearch(final List<Integer> arr, int low, int high, int key) 
    { 
       if (high < low) 
           return -1; 
         
       /* low + (high - low)/2; */       
       int mid = (low + high)/2;   
       if (key == arr.get(mid)) 
           return mid; 
       if (key > arr.get(mid)) 
           return binarySearch(arr, (mid + 1), high, key); 
       return binarySearch(arr, low, (mid -1), key); 
    } 
}
