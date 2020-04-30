//https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/


/*package whatever //do not write package name here */

import java.io.*;



public class GFG {

    public static void printAllPath(int a[][] , int i , int j , int m , int n , String str)
    {
        if(i>m || j>n)
            return ;

        if(i==m && j==n)
        {   str = str + Integer.toString(a[i][j]);
            System.out.println(str);
            return ;
        }

        str = str+Integer.toString(a[i][j])+" ";
        printAllPath(a , i+1, j , m  , n , str);
        printAllPath(a , i, j+1 , m  , n , str);
    }
    public static void main(String args[])
    {
        int a[][] = { {1 , 2 , 3} ,
                {4 , 5 , 6}} ;
        int m = 1 ;
        int n = 2 ;
        printAllPath(a , 0 , 0 , 1 , 2 , "");
    }

}
