//https://www.interviewbit.com/problems/set-matrix-zeros/
//https://www.geeksforgeeks.org/a-boolean-matrix-question/
//http://buttercola.blogspot.com/2014/08/leetcode-set-matrix-zeros.html


public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int R=a.size();
	    int C=a.get(0).size();
	    int row[]= new int [R];
        int col[]= new int [C];
        int i, j;
     
        /* Initialize all values of row[] as 0 */
        for (i = 0; i < R; i++)
        {
        row[i] = 1;
        }
     
     
        /* Initialize all values of col[] as 0 */
        for (i = 0; i < C; i++)
        {
        col[i] = 1;
        }
     
     
        /* Store the rows and columns to be marked as
        1 in row[] and col[] arrays respectively */
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                if (a.get(i).get(j) == 0)
                {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
     
        /* Modify the input matrix mat[] using the
        above constructed row[] and col[] arrays */
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                if ( row[i] == 0 || col[j] == 0 )
                {
                    a.get(i).set(j,0);
                }
            }
        }
	}
}
