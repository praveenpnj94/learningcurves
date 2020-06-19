//https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0/?track=PC-W7-GR&batchId=127
//https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int srcX = 0;
            int destX = 0;
            int srcY = 0;
            int destY = 0;
            boolean[][] vis = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    vis[i][j] = false;
                    if (a[i][j] == 1) {
                        srcX = i;
                        srcY = j;
                    } else if (a[i][j] == 2) {
                        destX = i;
                        destY = j;
                    }
                }
            }
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // if matrix[i][j] is source  
                    // and it is not visited 
                    if (a[i][j] == 1 && !vis[i][j]) {
                        // starting from i, j and then finding the path 
                        if (pathExists(a, n, i, j, destX, destY, vis) == 1) {
                            flag = true; // if path exists 
                            break;
                        }
                    }


                }
            }
            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    public static boolean isSafe(int[][] a, int n, int srcX, int srcY, int destX, int destY, boolean[][] vis) {
        if (srcX >= 0 && srcX < n && srcY >= 0 && srcY < n && a[srcX][srcY] != 0 && !vis[srcX][srcY]) {
            return true;
        }
        return false;
    }

    public static int pathExists(int[][] a, int n, int srcX, int srcY, int destX, int destY, boolean[][] vis) {

        if (isSafe(a, n, srcX, srcY, destX, destY, vis)) {
            vis[srcX][srcY] = true;
            if (a[srcX][srcY] == 2) {
                return 1;
            }
            if (pathExists(a, n, srcX, srcY + 1, destX, destY, vis) == 1) {
                return 1;
            }
            if (pathExists(a, n, srcX, srcY - 1, destX, destY, vis) == 1) {
                return 1;
            }
            if (pathExists(a, n, srcX - 1, srcY, destX, destY, vis) == 1) {
                return 1;
            }
            if (pathExists(a, n, srcX + 1, srcY, destX, destY, vis) == 1) {
                return 1;
            }
        }
        return 0;
    }
}