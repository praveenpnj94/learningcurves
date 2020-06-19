//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
//https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/

class Solution {
    public int countSquares(int[][] matrix) {
      int total = 0;
      int rows = matrix.length;
      int cols = matrix[0].length;
      int[][] res = new int[rows][cols];
      for(int i = 0; i < rows; i++){
          for(int j = 0; j < cols; j++){
              if(i == 0 || j == 0){
                  res[i][j]= matrix[i][j];
              }
              else{
                  if(matrix[i][j]==1){
                      res[i][j]= 1+ Math.min(res[i-1][j], Math.min(res[i][j-1], res[i-1][j-1]));
                  }
                  else{
                      res[i][j]=0;
                  }
              }
              total += res[i][j];
          }
      }
      return total;
  }
}