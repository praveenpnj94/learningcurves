//https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int top =0;
        int left =0;
        int right=n-1;
        int bottom = m-1;
        int dir =0;
        
        while(left<=right && top<=bottom){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir==1){
                for(int i=top;i<=bottom;i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir==2){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else{
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir=(dir+1)%4;
            
        }
        return list;
    }
}