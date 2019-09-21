//https://www.geeksforgeeks.org/median-of-two-sorted-arrays/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MedianOfTwoSortedArraysOfSameSize {
    static int getMedian(int ar1[], int ar2[], int n)
    {
    /* return -1 for
    invalid input */
        if (n <= 0)
            return -1;
        if (n == 1)
            return (ar1[0] + ar2[0]) / 2;
        if (n == 2)
            return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;

    /* get the median of
    the first array */
        int m1 = median(ar1, n);

    /* get the median of
    the second array */
        int m2 = median(ar2, n);

    /* If medians are equal then
    return either m1 or m2 */
        if (m1 == m2)
            return m1;

    /* if m1 < m2 then median must
    exist in ar1[m1....] and
                ar2[....m2] */
        if (m1 < m2)
        {
            if (n % 2 == 0)
                return getMedian(Arrays.copyOfRange(ar1, n / 2 - 1, n)
                        , ar2, n - n / 2 + 1);
            return getMedian(Arrays.copyOfRange(ar1, n / 2, n),
                    ar2, n - n / 2);
        }

/* if m1 > m2 then median must
exist in ar1[....m1] and
ar2[m2...] */
        if (n % 2 == 0)
            return getMedian(Arrays.copyOfRange(ar2, n / 2 - 1, n)
                    , ar1, n - n / 2 + 1);
        return getMedian(Arrays.copyOfRange(ar2, n / 2 , n)
                , ar1, n - n / 2);
    }

    /* Function to get median
    of a sorted array */
    static int median(int arr[], int n)
    {
        if (n % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2;
        else
            return arr[n / 2];
    }

    // Driver code
    public static void main(String[] args)
    {
        int ar1[] = {1, 2, 3, 6};
        int ar2[] = {4, 6, 8, 10};
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 == n2)
            System.out.println("Median is " + getMedian(ar1, ar2, n1));
        else
            System.out.println("Doesn't work for arrays "+ "of unequal size");
    }

    static int getMedianLinear(int ar1[], int ar2[], int n) 
    {    
        int i = 0;   
        int j = 0;  
        int count; 
        int m1 = -1, m2 = -1; 
       
        /* Since there are 2n elements, median will  
           be average of elements at index n-1 and  
           n in the array obtained after merging ar1  
           and ar2 */
        for (count = 0; count <= n; count++) 
        { 
            /* Below is to handle case where all  
              elements of ar1[] are smaller than  
              smallest(or first) element of ar2[] */
            if (i == n) 
            { 
                m1 = m2; 
                m2 = ar2[0]; 
                break; 
            } 
       
            /* Below is to handle case where all  
               elements of ar2[] are smaller than  
               smallest(or first) element of ar1[] */
            else if (j == n) 
            { 
                m1 = m2; 
                m2 = ar1[0]; 
                break; 
            } 
       
            if (ar1[i] < ar2[j]) 
            {    
                /* Store the prev median */
                m1 = m2;   
                m2 = ar1[i]; 
                i++; 
            } 
            else
            { 
                /* Store the prev median */
                m1 = m2;   
                m2 = ar2[j]; 
                j++; 
            } 
        } 
       
        return (m1 + m2)/2; 
    } 
}

