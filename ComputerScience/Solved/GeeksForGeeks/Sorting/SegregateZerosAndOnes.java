//https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once

class Solution {
    void segregate0and1(int[] arr, int n) {
        int left = 0; 
		int right = arr.length - 1; 
		
		while (left < right) { 
			if (arr[left] == 1) { 
				// swap 
				int temp = arr[left]; 
				arr[left] = arr[right]; 
				arr[right] = temp; 
				right--; 
			} else { 
				left++; 
			} 
		} 
    }

} 
