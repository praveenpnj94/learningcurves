//https://leetcode.com/problems/number-of-islands/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/

//DFS
//https://www.youtube.com/watch?v=CLvNe-8-6s8
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    public void dfs(int x, int y, char[][] grid){
        if(x<0 || y<0 || x>=grid.length||y>=grid[0].length||grid[x][y]=='0'){
            return;
        }
        grid[x][y]='0';
        dfs(x-1,y,grid);
        dfs(x+1,y,grid);
        dfs(x,y-1,grid);
        dfs(x,y+1,grid);
    }
}

//BFS
//https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfsFill(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();  
        int code = x*m+y;  
        queue.offer(code);  
        while(!queue.isEmpty())  
        {  
            code = queue.poll();  
            int i = code/m;  
            int j = code%m;  
            if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
            {  
                queue.offer((i-1)*m+j);  
                grid[i-1][j]='0';  
            }  
            if(i<n-1 && grid[i+1][j]=='1')  //down
            {  
                queue.offer((i+1)*m+j);  
                grid[i+1][j]='0';  
            }  
            if(j>0 && grid[i][j-1]=='1')  //left
            {  
                queue.offer(i*m+j-1);  
                grid[i][j-1]='0';  
            }  
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {  
                queue.offer(i*m+j+1);  
                grid[i][j+1]='0';  
            }
        } 
    }
}