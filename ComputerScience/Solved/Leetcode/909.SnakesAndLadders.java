//https://leetcode.com/problems/snakes-and-ladders/

class Solution {
    public int snakesAndLadders(int[][] board) {
        if(board==null||board.length==0){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer,Game> map = new HashMap<>();
        prepareHashMap(board,map);
        q.add(new Node(1,0));
        int finalval = (board.length)*(board.length);
        boolean[] vis = new boolean[finalval+1];
        vis[0]=true;
        vis[1]=true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            int w = curr.window;
            int d = curr.dist;
            if(w==finalval){
                return d;
            }
            for(int i=1;i<=6;i++){
                int nw = w+i;
                if(nw>finalval){
                    continue;
                }
                Game nwv = map.get(nw);
                    if(nwv.value==-1){
                    }
                    else{
                        nw = nwv.value;
                    }
                if(nw>finalval){
                    continue;
                }
                    if(!vis[nw]){
                        vis[nw]=true;
                        q.add(new Node(nw,d+1));
                    }
            }
        }
        return -1;
    }
    public void prepareHashMap(int[][] board,HashMap<Integer,Game> map){
        int n = board.length;
        int w =1;
        boolean res = true;
        for(int i=n-1;i>=0;i--){
            if(res){
                for(int j=0;j<n;j++){
                    map.put(w,new Game(w,i,j,board[i][j]));
                    w++;
                }
            }
            else{
                for(int j=n-1;j>=0;j--){
                    map.put(w,new Game(w,i,j,board[i][j]));
                    w++;
                }
            }
            res=!res;
        }
    }
}
class Node{
    int window;
    int dist;
    Node(int window, int dist){
        this.window = window;
        this.dist = dist;
    }
}
class Game{
    int window;
    int x;
    int y;
    int value;
    Game(int window, int x, int y, int value){
        this.window = window;
        this.x = x;
        this.y = y;
        this.value = value;
    }
}