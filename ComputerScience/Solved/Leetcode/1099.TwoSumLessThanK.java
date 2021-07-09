//https://leetcode.com/problems/two-sum-less-than-k/

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int S = -1;
        Arrays.sort(A);
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] + A[hi] < K) {
                S = Math.max(S, A[lo] + A[hi]);
                ++lo;
            }
            else
                --hi;
        }
        return S;
    }
}