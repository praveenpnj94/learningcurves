/**
 * 
 */
package binarytree.medium;

/**
 * @author praveen
 *
 *         12-Jul-2018 on 1:34:09 AM
 */
public class PostorderTraversalGivenInorderPreorder {
	static int preIndex = 0;
	public static void postOrderTraversalFromInorderAndPreorder(int[]in, int[]pre,int inStrt,int inEnd){
		if(inStrt > inEnd){
			return ;
		}     
		 
		int inIndex = search(in,inStrt,inEnd,pre[preIndex++]);
		// traverse left tree
		postOrderTraversalFromInorderAndPreorder(in, pre, inStrt, inIndex - 1);
		// traverse right tree
		postOrderTraversalFromInorderAndPreorder(in, pre, inIndex + 1, inEnd);
		
		// print root node at the end of traversal
	    System.out.print(in[inIndex]+" ");
		
	}
	public static int search(int[]in,int startIn,int endIn,int data){
		int i=0;
		for(i=startIn;i<endIn;i++){
			if(in[i]==data){
				return i;
			}
		}
		return i;
	}

}
