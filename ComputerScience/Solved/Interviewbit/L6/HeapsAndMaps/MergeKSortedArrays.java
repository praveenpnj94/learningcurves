//https://www.interviewbit.com/problems/merge-k-sorted-arrays/

public class Solution {
    public int[] solve(int[][] A) {
        if(A==null||A.length==0||A[0].length==0){
            return new int[0];
        }
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.add(A[i][j]);
            }
        }
        int[] res = new int[m*n];
        int j=0;
        while(pq.size()>0){
            res[j++]=pq.poll();
        }
        return res;
    }
}
