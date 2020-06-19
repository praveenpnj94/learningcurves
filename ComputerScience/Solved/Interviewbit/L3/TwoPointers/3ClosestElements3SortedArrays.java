//https://www.interviewbit.com/problems/array-3-pointers/
//https://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.size() && j < B.size() && k < C.size()) {
            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);
            int currMax = Math.max(Math.abs(a - b), Math.max(Math.abs(a - c), Math.abs(b - c)));
            min = Math.min(min, currMax);
            if (a <= b && a <= c) {
                i ++;
            } else if (b <= a && b <= c) {
                j ++;
            } else {
                k ++;
            }
        }
        return min;
        
    }
}
