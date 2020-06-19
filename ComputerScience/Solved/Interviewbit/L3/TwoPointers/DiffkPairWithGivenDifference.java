//https://www.interviewbit.com/problems/diffk/
//https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
public class Solution {
    public int diffPossible(int[] A, int B) {
        int n = A.length;
        int i=0;
        int j = 1;
        while(i<n && j<n){
            if(i!=j && A[j]-A[i]==B){
                return 1;
            }
            else if(A[j]-A[i]<B){
                j++;
            }
            else{
                i++;
            }
        }
        return 0;
    }
}
