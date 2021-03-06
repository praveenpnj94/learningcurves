//https://www.interviewbit.com/problems/pairs-with-given-xor/

public class Solution {
    public int solve(int[] arr, int x) {
        int result = 0; // Initialize result  
        int n = arr.length;
  
        // create empty set that stores the visiting  
        // element of array.  
        // Refer below post for details of unordered_set  
        // https://www.geeksforgeeks.org/unorderd_set-stl-uses/  
        HashSet<Integer> s = new HashSet<Integer>(); 
  
        for (int i = 0; i < n; i++)  
        { 
            // If there exist an element in set s  
            // with XOR equals to x^arr[i], that means  
            // there exist an element such that the  
            // XOR of element with arr[i] is equal to  
            // x, then increment count.  
            if (s.contains(x ^ arr[i]))  
            { 
                result++; 
            } 
  
            // Make element visited  
            s.add(arr[i]); 
        } 
  
        // return total count of  
        // pairs with XOR equal to x  
        return result; 
    }
}
