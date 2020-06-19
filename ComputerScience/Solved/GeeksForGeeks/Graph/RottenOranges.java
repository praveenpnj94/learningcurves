//https://www.youtube.com/watch?v=3hF3hP1MlUM&list=PLpO3gASfJEIJ4tnnYUX6vm8OhR92iGM7J&index=12
//https://leetcode.com/discuss/interview-question/411357/

class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes=0;
        if(grid==null||grid.length==0){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Node(i,j));
                }
            }
        }
        int[][] dim = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            minutes++;
            for(int i=0;i<size;i++){
                Node t = q.poll();
                int x = t.x;
                int y = t.y;
                for(int[] d:dim){
                    int nx = x+d[0];
                    int ny = y+d[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return minutes==0?0:minutes-1;
    }
}
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}