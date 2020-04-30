//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
//https://www.youtube.com/watch?v=K2E5fMMAf5U
//https://www.youtube.com/watch?v=nmaI2RC7SWU

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);
        int res =-1;
        int x=m-1;
        int y = n-1;
        while(x>=0 && y>=0){
            if(binaryMatrix.get(x,y)==1){
                res= y;
                y=y-1;
            }
            else{
                x=x-1;
            }
        }
        return res;
    }
}