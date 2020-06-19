//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((w2, w1) -> count.get(w1) - count.get(w2) );
        for (int word: count.keySet()) {
            heap.offer(word);
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]= heap.poll();
        }
        return ans;
    }
}