import java.util.Arrays;
import java.util.List;

import easy.RepeatAndMissingNumber;

/**
 * 
 */

/**
 * @author praveen on 09-Aug-20188:35:02 PM
 */
public class ArrayDriver {
	public static void main(String[] args) {

		/*************************** Spiral Order *******************************/
		/*
		 * ArrayList<Integer> l1= new ArrayList<Integer>(); l1.addAll(Arrays.asList(1,
		 * 2)); ArrayList<Integer> l2= new ArrayList<Integer>();
		 * l2.addAll(Arrays.asList(3,4)); ArrayList<Integer> l3= new
		 * ArrayList<Integer>(); l3.addAll(Arrays.asList(5,6)); List<ArrayList<Integer>>
		 * maplist=new ArrayList<ArrayList<Integer>>(); maplist.add(l1);
		 * maplist.add(l2); maplist.add(l3);
		 * System.out.println(SpiralMatrix.spiralOrder(maplist));
		 */
		/*************************************************************************/

		/*************************** Add One To Number *******************************/
		/*
		 * ArrayList<Integer> m= new ArrayList<Integer>(); m.addAll(Arrays.asList(0,9,
		 * 9)); System.out.println(OneToNumber.plusOneIB(m));
		 */
		/*************************************************************************/

		/*************************** Repeat and Missing Number Array *******************************/
		final List<Integer> l =Arrays.asList(3,1,2,5,3);
		System.out.println(RepeatAndMissingNumber.repeatedNumber(l));
		/*************************************************************************/
	}
}
