//https://www.interviewbit.com/problems/maximum-unsorted-subarray/
//https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

public class Solution {
    public int[] subUnsort(int[] arr) {
        int n = arr.length;
    int[] a =new int[2];
      int s = 0, e = n-1, i, max, min;   
       
      // step 1(a) of above algo
      for (s = 0; s < n-1; s++)
      {
        if (arr[s] > arr[s+1])
          break;
      }
      if (s == n-1)
      {
          int[] b =new int[1];
          b[0]=-1;
        return b;
      }
       
      // step 1(b) of above algo
      for(e = n - 1; e > 0; e--)
      {
        if(arr[e] < arr[e-1])
          break;
      }
       
      // step 2(a) of above algo
      max = arr[s]; min = arr[s];
      for(i = s + 1; i <= e; i++)
      {
        if(arr[i] > max)
          max = arr[i];
        if(arr[i] < min)
          min = arr[i];
      }
       
      // step 2(b) of above algo
      for( i = 0; i < s; i++)
      {
        if(arr[i] > min)
        {  
          s = i;
          break;
        }      
      } 
       
      // step 2(c) of above algo
      for( i = n -1; i >= e+1; i--)
      {
        if(arr[i] < max)
        {
          e = i;
          break;
        } 
      }
      a[0]=s;
      a[1]=e;
      return a;
      
    }
}
