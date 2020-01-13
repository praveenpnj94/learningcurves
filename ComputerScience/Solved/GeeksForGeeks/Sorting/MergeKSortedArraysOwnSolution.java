//https://www.geeksforgeeks.org/merge-k-sorted-arrays/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;



class GFG
{
    public static void main(String args[]) {
        int[][] arr = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        System.out.print(mergeKArrays(arr, arr.length));
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(arrays.length ==1){
            int[] apt = arrays[0];
            for(int x =0;x<apt.length;x++){
                al.add(apt[x]);
            }
            return al;
        }
        int size = k%2==0?k/2:k/2 + 1;
        int[][] temp = new int[size][];
        List<int[]> list = new ArrayList<int[]>();
        int i;
        for(i=0;i<k-1;i=i+2){
            ArrayList<Integer> mal = merge(arrays[i],arrays[i+1]);
            int l = mal.size();
            int[] res = new int[l];
            for(int j=0;j<l;j++){
                res[j] = mal.get(j);
            }
            list.add(res);
        }
        if(i<k){
            int[] rem = arrays[i];
            list.add(rem);
        }
        return mergeKArrays(list.toArray(temp),size);
    }
    public static ArrayList<Integer> merge(int[] L, int[] R)
    {
        // Find sizes of two subarrays to be merged
        int n1 = L.length;
        int n2 = R.length;
        int size= n1+n2;
        int[] arr = new int[size];
        ArrayList<Integer> al = new ArrayList<Integer>();
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = 0;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                al.add(arr[k]);
                i++;
            }
            else
            {
                arr[k] = R[j];
                al.add(arr[k]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            al.add(arr[k]);
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            al.add(arr[k]);
            j++;
            k++;
        }
        return al;
    }
}