//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        int i=0;
        while(i<k){
            int n = pq.peek();
            pq.poll();
            if(i==k-1){
                return n;
            }
            i++;
        }
        return -1;
    }
}