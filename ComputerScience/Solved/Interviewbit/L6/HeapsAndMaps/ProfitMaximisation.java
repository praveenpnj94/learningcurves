//https://www.interviewbit.com/problems/profit-maximisation/

public class Solution {
    public int solve(int[] A, int B) {
        if(A==null||A.length==0||B==0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:A){
            pq.add(num);
        }
        int i=0;
        int ans =0;
        while(i<B){
            int n = pq.peek();
            ans+=n;
            pq.poll();
            if(n-1>0){
                pq.add(n-1);
            }
            i++;
        }
        return ans;
    }
}
