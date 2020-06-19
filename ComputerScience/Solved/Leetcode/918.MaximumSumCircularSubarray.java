//https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
//https://leetcode.com/problems/maximum-sum-circular-subarray/
//https://www.youtube.com/watch?v=Q1TYVUEr-wY


class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = Integer.MIN_VALUE, curMax = 0, minSum = Integer.MAX_VALUE, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}