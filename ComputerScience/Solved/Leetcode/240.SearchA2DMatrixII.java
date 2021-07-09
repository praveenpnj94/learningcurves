//https://leetcode.com/problems/search-a-2d-matrix-ii/

// class Solution {
// public boolean searchMatrix(int[][] matrix, int target) {
//     if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//     if(matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
//     return helper(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
// }

// public boolean helper(int[][] matrix, int target, int rS, int rE, int cS, int cE) {
//     if(rS < 0 || rE >= matrix.length || cS < 0 || cE >= matrix[0].length || rS > rE || cS > cE) return false;
    
//     int rM = rS + (rE-rS)/2, cM = cS + (cE-cS)/2;
    
//     if(matrix[rM][cM] == target) return true;
//     else if(matrix[rM][cM] > target) {
//         return helper(matrix, target, rS, rM-1, cS, cM-1) || helper(matrix, target, rS, rM-1, cM, cE) || helper(matrix, target, rM, rE, cS, cM-1);
//     } else { // matrix[rM][cM] < target
//         return helper(matrix, target, rM+1, rE, cM+1, cE) || helper(matrix, target, rM+1, rE, cS, cM) || helper(matrix, target, rS, rM, cM+1, cE);
//     }
// }
// }

// class Solution {
//     int[][] matrix;
//     int target;
//     public boolean searchMatrix(int[][] matrix, int target) {
//         this.matrix = matrix;
//         this.target = target;
//         if(matrix.length==0)
//             return false;
//         return helper(0, 0, matrix.length-1, matrix[0].length-1);
//     }
//     /**
//     * @param x1, row coordinate of top left element of the matrix
//     * @param y1, column coordinate of top left elemeent of the matrix
//     * @param x2, row coordinate of bottom right element of the matrix
//     * @param y2, column coordinate of bottom right element of the matrix
//     */
//     private boolean helper(int x1, int y1, int x2, int y2){
//         if(x2<x1 || y2<y1 || x1>=matrix.length || y1>=matrix[0].length || x2<0 || y2<0)
//             return false;
//         int mx = (x2-x1)/2+x1;
//         int my = (y2-y1)/2+y1;
//         // Check the middle element of the matrix, if not found, 
//         // recursively call on sub matrices where
//         // the value could still exist. 
//         // You will realize that the resultant possible places will
//         // form a L shape on the original matrix.
//         // This L shape can be broken down into 2 matrices.
//         // If number found in any of the 2 matrices, we return true.
//         if(matrix[mx][my]==target)
//             return true;
//         else if(matrix[mx][my]<target){
//             return helper(x1,my+1,x2,y2) || helper(mx+1,y1,x2,my);
//         }else if(matrix[mx][my]>target){
//             return helper(x1,y1,x2,my-1) || helper(x1,my,mx-1,y2);
//         }else
//             return false;
//     }
// }


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}


