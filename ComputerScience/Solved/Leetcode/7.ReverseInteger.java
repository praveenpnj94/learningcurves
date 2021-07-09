//https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x<0){
            x=x*-1;
            isNegative = true;
        }
        long rev =0;
        while(x>0){
            int q = x%10;
            rev = rev*10 +q;
            x=x/10;
        }
        if(rev>Integer.MAX_VALUE){
            return 0;
        }
        return isNegative? (int)(rev*-1):(int) rev;
    }
}