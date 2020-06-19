//https://www.interviewbit.com/problems/counting-triangles/
//https://www.geeksforgeeks.org/find-number-of-triangles-possible/

public class Solution {
    public int nTriang(int[] A) {
        // int cnt=0;
        // int n = A.length;
        // Arrays.sort(A);
        // if(n<3) return 0;
        // for(int i = 0;i<n-2;i++){
        //     int k = i+2;
        //     for(int j=i+1;j<n-1;j++){
        //         while(k<n && A[i] + A[j] > A[k]) k++;
        //         if(k>j) cnt += k-j-1;
        //         cnt = cnt%1000000007;
        //     }
        // }
        // return cnt;
        int n = A.length; 
  
        Arrays.sort(A); 
  
        int count = 0; 
  
        for (int i = n - 1; i >= 1; i--) { 
            int l = 0, r = i - 1; 
            while (l < r) { 
                if (A[l] + A[r] > A[i]) { 
  
                    // If it is possible with a[l], a[r] 
                    // and a[i] then it is also possible 
                    // with a[l+1]..a[r-1], a[r] and a[i] 
                    count += r - l; 
                    count = count%1000000007;
  
                    // checking for more possible solutions 
                    r--; 
                } 
                else // if not possible check for 
                // higher values of arr[l] 
                { 
                    l++; 
                } 
            } 
        } 
        return count;
    }
}
