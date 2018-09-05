//https://www.interviewbit.com/problems/noble-integer/
//https://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-elements-is-equal-to-value/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        // Total runtime: O(n log n) due to sort
        Collections.sort(A);
        
        for(int i = 0; i < A.size(); i++) {
            // Handle duplicates (only check for rightmost duplicate), skip others
            if(i < A.size() - 1 && A.get(i) == A.get(i + 1)) {
                continue;
            }
            // Check if the remaining values to the right are equal to the current value
            if(A.size() - i - 1 == A.get(i)) {
                return 1;
            }
        }
        
        return -1;
    }
}