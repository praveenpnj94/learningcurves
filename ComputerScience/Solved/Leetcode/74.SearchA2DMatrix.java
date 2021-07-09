//https://leetcode.com/problems/search-a-2d-matrix/
//https://www.youtube.com/watch?v=eT0UqrYuqbg&ab_channel=NickWhite
//https://www.youtube.com/watch?v=HMqUv7zmxmo&ab_channel=ProgrammingTutorials

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows*cols - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid/cols][mid%cols] ==target){
                return true;
            }
            else if (matrix[mid/cols][mid%cols] <target){
                start = mid + 1;
            }
            else{
                end = mid-1;
            } 
        }
        return false;
    }
}