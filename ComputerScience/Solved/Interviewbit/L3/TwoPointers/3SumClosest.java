//https://www.interviewbit.com/problems/3-sum/
//https://www.geeksforgeeks.org/find-a-triplet-in-an-array-whose-sum-is-closest-to-a-given-number/

public class Solution {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<A.length-2;i++){
            int l = i+1;
            int r = A.length-1;
            while(l<r){
                int sum = A[i]+A[l]+A[r];
                int diff = Math.abs(sum - B);
                if(diff == 0) 
                    return sum; 
                if(diff < min){
                    min = diff;
                    result = sum;
                }
                if(sum <= B)
                    l++;
                else
                    r--;
            }
        }
        return result;
    }
}
