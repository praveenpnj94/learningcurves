//https://www.interviewbit.com/problems/min-xor-value/
//https://www.geeksforgeeks.org/minimum-xor-value-pair/

public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        int min =Integer.MAX_VALUE;
        Collections.sort(A);
        for(int i=0;i<A.size()-1;i++){
            min = Math.min(A.get(i)^A.get(i+1),min);
        }
        return min;
    }
}