//https://leetcode.com/problems/power-of-two/solution/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        if(n==1||n==2){
            return true;
        }
        while(n>1){
            int r = n%2;
            if(r%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;
    }
}
class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n == 0) return false;
      while (n % 2 == 0) n /= 2;
      return n == 1;
    }
}
class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n == 0) return false;
      long x = (long) n;
      return (x & (x - 1)) == 0;
    }
}
class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n == 0) return false;
      long x = (long) n;
      return (x & (-x)) == x;
    }
}