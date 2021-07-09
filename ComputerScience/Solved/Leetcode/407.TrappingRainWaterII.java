//https://leetcode.com/problems/trapping-rain-water-ii/
//https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue/202680
//https://www.youtube.com/watch?v=kJlXN35IDto
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0||heightMap[0].length==0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a,b)->a.height-b.height);
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            vis[i][0] = true;
            vis[i][n-1] = true;
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int i=0;i<n;i++){
            vis[0][i] = true;
            vis[m-1][i] = true;
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
        }
        int[][] dim = {{0,1},{0,-1},{1,0},{-1,0}};
        int res=0;
        while(!pq.isEmpty()){
            Cell temp = pq.poll();
            int x = temp.x;
            int y = temp.y;
            int h = temp.height;
            for(int[] d:dim){
                int r = x+d[0];
                int c = y+d[1];
                if(r>0 && c>0 && r<m-1 && c<n-1 && !vis[r][c]){
                    vis[r][c]=true;
                    res+=Math.max(0,h-heightMap[r][c]);
                    pq.offer(new Cell(r,c,Math.max(h,heightMap[r][c])));
                }
            }
        }
        return res;
    }
}
class Cell{
    int x;
    int y;
    int height;
    
    Cell(int x, int y, int height){
        this.x = x;
        this.y = y;
        this.height = height;
    }
}