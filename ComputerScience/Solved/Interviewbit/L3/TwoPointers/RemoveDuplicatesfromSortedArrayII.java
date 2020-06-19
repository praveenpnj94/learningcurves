//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        //
        // Initialize the counter and the second pointer.
        //
        int j = 1, count = 1;
        
        //
        // Start from the second element of the array and process
        // elements one by one.
        //
        for (int i = 1; i < a.size(); i++) {
            
            //
            // If the current element is a duplicate, increment the count.
            //
            if (a.get(i).intValue() == a.get(i-1).intValue()) {
                
                count++;
                
            } else {
                
                //
                // Reset the count since we encountered a different element
                // than the previous one.
                //
                count = 1;
            }
            
            //
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            //
            if (count <= 2) {
                a.set(j,a.get(i));
                j++;
            }
        }
        return j;
    }
}
