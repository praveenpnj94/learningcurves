//https://practice.geeksforgeeks.org/problems/x-total-shapes/0/?track=PC-W7-GR&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void DFS(boolean visited[][], char arr[][], int i, int j, int n, int k) {
        if(i<0||i>=n||j<0||j>=k||arr[i][j]=='O'||visited[i][j]){
                return;
        }
        visited[i][j] = true;
        DFS(visited, arr, i + 1, j, n, k);
        DFS(visited, arr, i - 1, j, n, k);
        DFS(visited, arr, i, j + 1, n, k);
        DFS(visited, arr, i, j - 1, n, k);
    }
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int l = ab.nextInt();
        while (l-- > 0) {
            int count = 0;
            int n = ab.nextInt();
            int k = ab.nextInt();
            char arr[][] = new char[n][k];
            for (int i = 0; i < n; i++) {
                String tm = new String(ab.next());
                for (int j = 0; j < k; j++)
                    arr[i][j] = tm.charAt(j);
            }
            boolean visited[][] = new boolean[n][k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    if (arr[i][j] == 'X' && !visited[i][j]) {
                        count++;
                        DFS(visited, arr, i, j, n, k);
                    }
                }
            }
            System.out.println(count);
        }

    }
}