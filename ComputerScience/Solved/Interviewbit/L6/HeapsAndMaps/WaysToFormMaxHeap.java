//https://www.interviewbit.com/problems/ways-to-form-max-heap/
//https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/

/*

Now as all the remaining (n-1) elements are less than the element present at the root(The Max Element), whichever L elements among ‘n-1` elements we put in the left sub-tree, it doesn’t matter because it will satisfy the Max Heap property.

So now there are (n-1)CL ways to pickup L elements from (n-1) elements. And then recurse the solution.

So final equation will be as follows :

 (n-1)CL * getNumberOfMaxHeaps(L) * getNumberOfMaxHeaps(R) 
So now the question remains only of finding L for given n. It can be found as follows:

Find the height of the heap h = log2(n)

Find the max number of elements that can be present in the hth level of any heap . Lets call it m. m = 2h

Find the number of elements that are actually present in last level(hth level) in heap of size n. Lets call it p. p = n - (2h - 1)

Now if the last level of the heap is more than or equal to exactly half filled, then L would be 2h - 1

However if it is half filled then it will reduced by the number of elements in last level left to fill exactly half of the last level.

So final equation for L will be as follows :

 L = 2h - 1 if p >= m/2
                    = 2h - 1 - (m/2 - p) if p<(m/2) 

*/


public class Solution {
    public int solve(int A) {
        long[][] combs = getCombs(A);
        return (int) (helper(A, combs) % 1000000007);
    }
    
    private long helper(int A, long[][] combs) {
        if (A <= 1) {
            return 1;
        }
        int n = A;
        int h = 0;
        while (A > 1) {
            h ++;
            A /= 2;
        }
        int m = (int) Math.pow(2, h);
        int p = n - (m - 1);
        // L = 2h - 1 if p >= m/2
        //   = 2h - 1 - (m/2 - p) if p<(m/2)
        int L = 0;
        if (p >= m / 2) {
            L = m - 1;
        } else {
            L = m - 1 - (m / 2 - p);
        }
        return (((combs[n - 1][L] * helper(L, combs)) % 1000000007 * helper(n - 1 - L, combs) % 1000000007));
    }
    
    private long[][] getCombs(int A) {
        long[][] combs = new long[A + 1][A + 1];
        for (int n = 1; n <= A; n ++) {
            for (int r = 0; r <= n; r ++) {
                if (n == r || r == 0) {
                    combs[n][r] = 1;
                } else {
                    combs[n][r] = (combs[n - 1][r] + combs[n - 1][r - 1]) % 1000000007;
                }
            }
        }
        return combs;
    }
}
