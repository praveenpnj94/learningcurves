//https://leetcode.com/problems/walls-and-gates/

class Solution {
    int val = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null||rooms.length==0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0){
                    q.add(new int[] {i,j});
                }
            }
        }
        int[][] dim = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            for(int[] d:dim){
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx>=0 && ny>=0 && nx<m && ny<n && rooms[nx][ny]==val){
                    rooms[nx][ny] = rooms[x][y]+1;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }
}