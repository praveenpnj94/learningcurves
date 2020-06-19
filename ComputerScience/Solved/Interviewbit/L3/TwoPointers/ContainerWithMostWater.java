//https://www.interviewbit.com/problems/container-with-most-water/
//https://www.youtube.com/watch?v=TI3e-17YAlc
//https://leetcode.com/problems/container-with-most-water/

public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int maxarea = 0, l = 0, r = A.size() - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(A.get(l), A.get(r)) * (r - l));
            if (A.get(l) < A.get(r))
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
