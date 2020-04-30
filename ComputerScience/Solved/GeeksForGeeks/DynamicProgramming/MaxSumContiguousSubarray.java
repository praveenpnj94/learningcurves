class Geeks
{
    public long maximumSum(int arr[], int sizeOfArray)
    {
       long  dp[]=new long[sizeOfArray];//declaring dp array 
       dp[0]=arr[0];
       long  answer=arr[0];
       for(int i=1;i<sizeOfArray;i++)
       {
           //The maximum sum at dp[i] will be max of (current array element+dp[i-1]) and (current array element)
       //Complete this code
           dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
           answer = Math.max(answer,dp[i]);
       }
       //To print the dp array
       for(int i=0;i<sizeOfArray;i++)
       {
           System.out.print(dp[i]+" ");
       }
       System.out.println();
       //printing end
       return answer;
    }

}
