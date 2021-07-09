//https://leetcode.com/problems/robot-room-cleaner/

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        dfs(robot,0,0,0,new HashSet<String>());
    }
    
    public void dfs(Robot r, int x, int y, int dir,HashSet<String> hs){
        String pos = x+"_"+y;
        if(hs.contains(pos)){
            return;
        }
        r.clean();
        hs.add(pos);
        for(int i=0;i<4;i++){
            if(r.move()){
            int nextX = x;
            int nextY = y;
            switch(dir){
                case 0:
                    nextY--;
                    break;
                case 90:
                    nextX++;
                    break;
                case 180:
                    nextY++;
                    break;
                case 270:
                    nextX--;
                    break;
            }
            dfs(r,nextX,nextY,dir,hs);
            goBack(r);
            }
            dir+=90;
            dir=dir%360;
            r.turnRight();
        }
    }
    
    public void goBack(Robot r){
        r.turnLeft();
        r.turnLeft();
        r.move();
        r.turnLeft();
        r.turnLeft();
    }
}