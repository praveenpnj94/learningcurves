//https://www.interviewbit.com/problems/capture-regions-on-board/

public class Solution{
    public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) return;
		int m = board.length;
		int n = board[0].length;

		// go through the first column and the last column
		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);	
		}

		// go through the first row and the last row
		for (int j = 1; j < n - 1; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);	
		}

                // make all the remaining 'O' to 'X'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
                                if (board[i][j] == '*') board[i][j] = 'O';
			}
		}
	}


	// make every 'O' that we meet to '*' 
        // It is safe because we always start from the border
	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
		if (board[i][j] == 'X' || board[i][j] == '*') return;
		board[i][j] = '*';
		dfs(board, i - 1, j);
		dfs(board, i + 1, j);
		dfs(board, i, j - 1);
		dfs(board, i, j + 1);
	}
}

//bfs

public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        
        int rowN = board.length;
        int colN = board[0].length;
        Queue<Point> queue = new LinkedList<Point>();
       
       //get all 'O's on the edge first
        for (int r = 0; r< rowN; r++){
        	if (board[r][0] == 'O') {
        		board[r][0] = '+';
                queue.add(new Point(r, 0));
        	}
        	if (board[r][colN-1] == 'O') {
        		board[r][colN-1] = '+';
                queue.add(new Point(r, colN-1));
        	}
        	}
        
        for (int c = 0; c< colN; c++){
        	if (board[0][c] == 'O') {
        		board[0][c] = '+';
                queue.add(new Point(0, c));
        	}
        	if (board[rowN-1][c] == 'O') {
        		board[rowN-1][c] = '+';
                queue.add(new Point(rowN-1, c));
        	}
        	}
        

        //BFS for the 'O's, and mark it as '+'
        while (!queue.isEmpty()){
        	Point p = queue.poll();
        	int row = p.x;
        	int col = p.y;
        	if (row - 1 >= 0 && board[row-1][col] == 'O') {board[row-1][col] = '+'; queue.add(new Point(row-1, col));}
        	if (row + 1 < rowN && board[row+1][col] == 'O') {board[row+1][col] = '+'; queue.add(new Point(row+1, col));}
        	if (col - 1 >= 0 && board[row][col - 1] == 'O') {board[row][col-1] = '+'; queue.add(new Point(row, col-1));}
            if (col + 1 < colN && board[row][col + 1] == 'O') {board[row][col+1] = '+'; queue.add(new Point(row, col+1));}        	      
        }
        

        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i<rowN; i++){
        	for (int j=0; j<colN; j++){
        		if (board[i][j] == 'O') board[i][j] = 'X';
        		if (board[i][j] == '+') board[i][j] = 'O';
        	}
        }
       
        
    }
}