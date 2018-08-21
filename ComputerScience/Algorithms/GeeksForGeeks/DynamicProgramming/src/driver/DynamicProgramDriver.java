/**
 * 
 */
package driver;

import medium.MaxSumContiguousSubArray;

/**
 * @author praveen
 *15-Aug-2018 5:49:22 PM
 */
public class DynamicProgramDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {
     /********************** Largest Sum Contiguous Subarray ***********************************/
        int a[] = {-1,2,-3,-4};
        int maxSum = MaxSumContiguousSubArray.getMaxSumContiguousSubArray(a);
        System.out.println("Maximum contiguous sum is "+ maxSum);

    }

}
