//https://www.interviewbit.com/problems/subarray-with-given-xor/
//https://www.youtube.com/watch?v=lO9R5CaGRPY&ab_channel=takeUforward

public class Solution {
    public int solve(int[] arr, int m) {
        int n = arr.length;
        int ans = 0;   
        int xor =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            xor^=arr[i];
            if(xor==m){
                ans++;
            }
            map.put(xor,map.getOrDefault(xor,0)+1);
            if(map.containsKey(xor^m)){
                ans+=map.get(xor^m);
            }
        }
        return ans;
    }
}
