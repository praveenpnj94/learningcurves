//https://leetcode.com/problems/bitwise-and-of-numbers-range/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while(n>m){
            n=n & n-1;
        }
        return m & n;
    }
}

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
      int shift = 0;
      // find the common 1-bits
      while (m < n) {
        m >>= 1;
        n >>= 1;
        ++shift;
      }
      return m << shift;
    }
  }