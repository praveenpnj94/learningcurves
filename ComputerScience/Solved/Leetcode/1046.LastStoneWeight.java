//https://leetcode.com/problems/last-stone-weight/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)-> y-x);
        int n = stones.length;
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a>b){
                pq.add(a-b);
            }
            else if(a<b){
                pq.add(b-a);
            }
        }
        return pq.size()==1?pq.poll():0;
    }
}