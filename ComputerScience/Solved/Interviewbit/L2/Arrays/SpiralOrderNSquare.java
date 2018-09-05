//https://www.interviewbit.com/problems/spiral-order-matrix-ii/


public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int top=0;
        int left=0;
        int right=A-1;
        int bottom=A-1;
        int rows=A;
        int cols=A;
        int dir=0;
        int[][] a= new int[A][A];
        int num=1;
        while(left<=right && top<=bottom){
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    a[top][i]=num;
                    num++;
                }
                top++;
            } else if (dir == 1) {
                for (int j = top; j <= bottom; j++) {
                    a[j][right]=num;
                    num++;
                }
                right--;
            } else if (dir == 2) {
                for (int k = right; k >= left; k--) {
                    a[bottom][k]=num;
                    num++;
                }
                bottom--;
            } else if (dir == 3) {
                for (int m = bottom; m >= top; m--) {
                    a[m][left]=num;
                    num++;
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        for(int alpha=0;alpha<A;alpha++){
            ArrayList<Integer> ml= new ArrayList<Integer>();
            for(int beta=0;beta<A;beta++){
                ml.add(a[alpha][beta]);
            }
            al.add(ml);
        }
        return al;
    }
}
