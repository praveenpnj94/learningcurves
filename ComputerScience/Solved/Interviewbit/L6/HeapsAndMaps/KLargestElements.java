//https://www.interviewbit.com/problems/k-largest-elements/

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A==null||A.size()==0){
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:A){
            pq.add(num);
        }
        int i=0;
        while(i<B){
            res.add(pq.poll());
            i++;
        }
        return res;
    }
}
