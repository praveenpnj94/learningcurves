//https://www.techiedelight.com/print-continuous-subarray-with-maximum-sum/

class Main
{
    // Function to print contiguous subarray with the largest sum
    // in a given set of integers
    public static void kadane(int[] A)
    {
        // stores maximum sum subarray found so far
        int maxSoFar = 0;
 
        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;
 
        // stores endpoints of maximum sum subarray found so far
        int start = 0, end = 0;
 
        // stores starting index of a positive-sum sequence
        int beg = 0;
 
        // traverse the given array
        for (int i = 0; i < A.length; i++)
        {
            // update the maximum sum of subarray "ending" at index `i`
            maxEndingHere = maxEndingHere + A[i];
 
            // if the maximum sum is negative, set it to 0
            if (maxEndingHere < 0)
            {
                maxEndingHere = 0;        // empty subarray
                beg = i + 1;
            }
 
            // update result if the current subarray sum is found to be greater
            if (maxSoFar < maxEndingHere)
            {
                maxSoFar = maxEndingHere;
                start = beg;
                end = i;
            }
        }
 
        System.out.println("The sum of contiguous subarray with the " +
                            "largest sum is " +    maxSoFar);
 
        System.out.print("The contiguous subarray with the largest sum is ");
        for (int i = start; i <= end; i++) {
            System.out.print(A[i] + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        kadane(A);
    }
}