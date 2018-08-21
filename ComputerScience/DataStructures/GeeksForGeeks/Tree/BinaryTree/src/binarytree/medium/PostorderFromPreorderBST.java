/**
 * 
 */
package binarytree.medium;

/**
 * @author praveen
 *
 * 24-Jul-2018 on 2:05:40 PM
 */
public class PostorderFromPreorderBST {
	public static void generatePostorderFromPreorderRecursively(int preorderArray[], int n) {
		generatePostorderFromPreorderRecursivelyUtil(preorderArray,n,Integer.MIN_VALUE,Integer.MAX_VALUE,new Index());
	}
	public static void generatePostorderFromPreorderRecursivelyUtil(int preorderArray[],int n,int minval,int maxval,Index preIndex ) {
	    // If entire preorder array is traversed then
	    // return as no more element is left to be
	    // added to post order array.
	    if (preIndex.index == n)
	        return;
	 
	    // If array element does not lie in range specified,
	    // then it is not part of current subtree.
	    if (preorderArray[preIndex.index] < minval || preorderArray[preIndex.index] > maxval) {
	        return;
	    }
	    
	    // Store current value, to be printed later, after
	    // printing left and right subtrees. Increment
	    // preIndex to find left and right subtrees,
	    // and pass this updated value to recursive calls.
	    int val = preorderArray[preIndex.index];
	    preIndex.index=preIndex.index+1;
	    
	    generatePostorderFromPreorderRecursivelyUtil(preorderArray, n, minval, val, preIndex);
	    generatePostorderFromPreorderRecursivelyUtil(preorderArray, n, val, maxval, preIndex);
	    
	    System.out.print(val+" ");
		
	}
}

class Index {
    
    int index = 0;
}
