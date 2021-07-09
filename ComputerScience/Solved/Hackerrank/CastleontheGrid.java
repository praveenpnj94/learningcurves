//https://www.hackerrank.com/challenges/castle-on-the-grid/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX,startY,0));
        if(grid[startX].charAt(startY)=='X'||grid[goalX].charAt(goalY)=='X'){
            return 0;
        }
        int[][] dims= {{-1,0},{1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length();
        boolean[][] vis = new boolean[m][n];
        vis[startX][startY]=true;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x==goalX && p.y==goalY){
                return p.moves;
            }
            for(int[] d:dims){
                int dx = d[0], dy = d[1];

                for (int i = p.x + dx, j = p.y + dy;
                    i < m && i >= 0 && j < n && j >= 0 && grid[i].charAt(j) == '.';
                    i = i + dx, j = j + dy) 
                {
                    if (!vis[i][j]) {
                        vis[i][j] = true;
                        q.add(new Point(i,j,p.moves+1));
                    }
                }                               
            }
        }
        return -1;        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
class Point{
    int x;
    int y;
    int moves;
    Point(int x, int y, int moves){
        this.x=x;
        this.y=y;
        this.moves=moves;
    }
}
