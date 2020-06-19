//https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1/0/?track=PC-W7-GR&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
    public static class Node {
        public int row;
        public int col;
        public Node(int _row, int _col) {
            this.row = _row;
            this.col = _col;
        }
    }
    
    public static int[] rowMoves = {-1, 1, 0, 0};
    public static int[] colMoves = {0, 0, -1, 1};
    
    public static int bfs(int[][] matrix, int n, int m, int uRow, int uCol) {
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.offer(new Node(uRow, uCol));
        visited[uRow][uCol] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                Node adjNode = new Node(node.row+rowMoves[i], node.col+colMoves[i]);
                
                if(adjNode.row < 0 || adjNode.row >= n) continue;
                if(adjNode.col < 0 || adjNode.col >= m) continue;
                
                if(!visited[adjNode.row][adjNode.col]) {
                    queue.offer(adjNode);
                    visited[adjNode.row][adjNode.col] = true;
                    
                    if(matrix[adjNode.row][adjNode.col] == 1)
                        return Math.abs(uRow-adjNode.row) +
                                Math.abs(uCol-adjNode.col);
                }
            }
        }
        
        return -1;
    }
    
    public static int[][] solve(int[][] matrix, int n, int m) {
        int[][] result = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    result[i][j] = bfs(matrix, n, m, i, j);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        
        return result;
    }
    
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		while(T > 0) {
		    int n = scanner.nextInt();
		    int m = scanner.nextInt();
		    int[][] matrix = new int[n][m];
		    
		    for(int i = 0; i < n; i++) {
		        for(int j = 0; j < m; j++) {
		            matrix[i][j] = scanner.nextInt();
		        }
		    }

		    int[][] result = solve(matrix, n, m);
    	    for(int i = 0; i < n; i++) {
		        for(int j = 0; j < m; j++) {
		            System.out.print(result[i][j] + " ");
		        }
		    }
		    System.out.println();
		    
		    T--;
		}
	}
}




