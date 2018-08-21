/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
package medium;

import java.util.ArrayList;

/**
 * @author praveen on 09-Aug-201811:09:44 PM
 */
public class MinStepsInfiniteGride {
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int s1 = X.size(), s2 = Y.size(), ans = 0;

		for (int i = 1; i < s1; i++)

		{

			ans = ans + (Math.abs(X.get(i) - X.get(i - 1)) < Math.abs(Y.get(i) - Y.get(i - 1))
					? Math.abs(Y.get(i) - Y.get(i - 1))
					: Math.abs(X.get(i) - X.get(i - 1)));

		}

		return ans;

	}
}
