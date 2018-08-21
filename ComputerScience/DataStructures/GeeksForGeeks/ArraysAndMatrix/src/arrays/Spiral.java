/**
 * 
 */
package arrays;

/**
 * @author praveen
 *
 */
public class Spiral {

    public static void printSpiral(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        int top = 0;
        int bottom = x - 1;
        int left = 0;
        int right = y - 1;
        int dir = 0;
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(A[top][i] + " ");
                }
                top++;
            } else if (dir == 1) {
                for (int j = top; j <= bottom; j++) {
                    System.out.print(A[j][right] + " ");
                }
                right--;
            } else if (dir == 2) {
                for (int k = right; k >= left; k--) {
                    System.out.print(A[bottom][k] + " ");
                }
                bottom--;
            } else if (dir == 3) {
                for (int m = bottom; m >= top; m--) {
                    System.out.print(A[m][left] + " ");
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
    }
}
