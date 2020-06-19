//https://www.interviewbit.com/problems/knight-on-chess-board/

public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(C,D,0));
        int[][] dim = {{-2,-1},{2,-1},{-2,1},{2,1},{-1,-2},{-1,2},{1,-2},{1,2}};
        boolean[][] vis = new boolean[A+1][B+1];
        for(boolean[] v:vis){
            Arrays.fill(v,false);
        }
        vis[C][D]=true;
        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int dist = temp.dist;
            if(x==E && y == F){
                return dist;
            }
            for(int[] d:dim){
                int nr = x+d[0];
                int nc = y+d[1];
                if(nr<1||nc<1||nr>=A+1||nc>=B+1||vis[nr][nc]) continue;
                vis[nr][nc]=true;
                q.add(new Node(nr,nc,dist+1));
            }
        }
        return -1;
    }
}
class Node{
    int x;
    int y;
    int dist;
    Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
