//https://www.interviewbit.com/problems/rearrange-array/
//https://www.geeksforgeeks.org/rearrange-given-array-place/

public class Solution {
	public void arrange(ArrayList<Integer> a) {
	    int n = a.size();
	    // First step: Increase all values by (arr[arr[i]]%n)*n 
        for (int i = 0; i < n; i++) {
            a.set(i,a.get(i)+(a.get(a.get(i))%n)*n);
        }
  
        // Second Step: Divide all values by n 
        for (int i = 0; i < n; i++) {
            a.set(i,a.get(i)/n);
        }
	}
}
