//https://leetcode.com/problems/number-complement/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/

class Solution {
    public int findComplement(int num) {
      // n is a length of num in binary representation
      int n = (int)( Math.log(num) / Math.log(2) ) + 1;
      // bitmask has the same length as num and contains only ones 1...1
      int bitmask = (1 << n) - 1;
      // flip all bits
      return bitmask ^ num;
    }
}