//https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1

class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        if(mat==null||mat.length==0||mat[0].length==0){
            return 0;
        }
        
        int i = 0;
        int j = M-1;
        
        while(i<N && j>=0){
            if(mat[i][j]==X){
                return 1;
            }
            else if(mat[i][j]>X){
                j--;
            }
            else{
                i++;
            }
        }
        return 0;
    }
}