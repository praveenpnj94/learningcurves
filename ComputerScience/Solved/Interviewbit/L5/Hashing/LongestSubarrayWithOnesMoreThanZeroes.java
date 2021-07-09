//https://www.interviewbit.com/problems/longest-subarray-length/
//https://www.geeksforgeeks.org/longest-subarray-count-1s-one-count-0s/

public class Solution {
    public int solve(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int sum =0;
        int maxLen=0;
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=A[i]==0?-1:1;
            if(sum==1){
                maxLen=i+1;
            }
            else if(!map.containsKey(sum)){
                map.put(sum, i);
            } 
            if(map.containsKey(sum-1)){
                maxLen=Math.max(maxLen,i-map.get(sum-1));
            } 
        }
        return maxLen;
    }
}
