//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1#

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k < j; k++){
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
    }
}

//https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35&ab_channel=AdityaVerma
class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return helper(arr,1,N-1,dp);
    }
    
    static int helper(int[] arr, int i, int j,int[][] dp){
        if(i>=j){
            return dp[i][j]=0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k =i;k<=j-1;k++){
            int temp = helper(arr,i,k,dp)+helper(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,temp);
        }
        return dp[i][j]=min;
    }
}



