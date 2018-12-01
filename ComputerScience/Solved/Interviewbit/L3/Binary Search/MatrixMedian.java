//https://www.interviewbit.com/problems/matrix-median/
//https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/

public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        
        if(A == null || A.size() == 0)
            return 0;
            
        int row = A.size();
        int col = A.get(0).size();
        
        int cntSmaller = 0, cntRequired = (row * col) / 2;
        
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = 0;
        boolean fnd = false;
        int pos = 0,ans = 0;
        
        while(low <= high)
        {
            mid = (low + high) / 2;
            fnd = false;
            cntSmaller = 0;
            
            for(int i = 0; i < row; i++)
            {
                pos = binarySearch(A.get(i),mid);
                // if(mid < 10)
                //     System.out.println(mid + " " + pos);
                cntSmaller += pos;
                // if(A.get(i).get(pos) == mid)
                //     fnd = true;
            }
            
            if(cntSmaller < cntRequired + 1)
                low = mid + 1;
            else
            {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    
    public int binarySearch(ArrayList<Integer> A, int n)
    {
        if(A == null)
            return -1;
        
        if(A.get(0) > n)
            return 0;
            
        int low,mid,high;
        
        low = 0;
        mid = 0;
        high = A.size() - 1;
        
        while(low <= high)
        {
            mid = (low + high) / 2;
            
            // if(A.get(mid) == n && (mid == A.size()-1 || A.get(mid+1) > A.get(mid)))
            //     return mid;
            // else 
            if(A.get(mid) > n)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
