//https://leetcode.com/problems/powx-n/

class Solution {
    // public double myPow(double x, int n) {
    //     long N = n;
    //     if (N < 0) {
    //         x = 1 / x;
    //         N = -N;
    //     }
    //     double ans = 1;
    //     double current_product = x;
    //     for (long i = N; i > 0; i /= 2) {
    //         if ((i % 2) == 1) {
    //             ans = ans * current_product;
    //         }
    //         current_product = current_product * current_product;
    //     }
    //     return ans;
    // }
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
            
        double h = myPow(x, n / 2);
        
        if(n % 2 == 0)
            return h * h;
        else if(n > 0)
            return h * h * x;
        else
            return h * h / x;
    }
}