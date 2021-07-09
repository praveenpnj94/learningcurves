//https://www.interviewbit.com/problems/palindrome-partitioning-ii/

//https://leetcode.com/problems/palindrome-partitioning-ii/
//https://www.youtube.com/watch?v=9h10fqkI7Nk&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=38

class Solution {
    public int minCut(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return helper(A,0,n-1,dp);
    }
    
    public int helper(String s, int i, int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(isPalindrome(s,i,j)){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++){
            int left = -1;
            if(dp[i][k]!=-1){
                left = dp[i][k];
            }
            else{
                left = helper(s,i,k,dp);
                dp[i][k]=left;
            }
            
            int right = -1;
            if(dp[k+1][j]!=-1){
                right = dp[k+1][j];
            }
            else{
                right = helper(s,k+1,j,dp);
                dp[k+1][j]=right;
            }
            
            min = Math.min(min,1+left+right);
        }
        
        return dp[i][j]=min;
    }
    
    public boolean isPalindrome(String s, int i, int j){
        if(i>j){
            return false;
        }
        
        if(i==j){
            return true;
        }
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}



/********** */

class Solution {
    public int minCut(String str) {
        // Get the length of the string 
        int n = str.length(); 
  
        /* Create two arrays to build the solution 
        in bottom up manner 
           C[i] = Minimum number of cuts needed for 
           palindrome partitioning of substring 
           str[0..i] 
           P[i][j] = true if substring str[i..j] is  
           palindrome, else false 
           Note that C[i] is 0 if P[0][i] is true */
        int[] C = new int[n]; 
        boolean[][] P = new boolean[n][n]; 
  
        int i, j, k, L; // different looping variables 
  
        // Every substring of length 1 is a palindrome 
        for (i = 0; i < n; i++) { 
            P[i][i] = true; 
        } 
  
        /* L is substring length. Build the solution  
        in bottom up manner by considering all substrings  
        of length starting from 2 to n. */
        for (L = 2; L <= n; L++) { 
            // For substring of length L, set different 
            // possible starting indexes 
            for (i = 0; i < n - L + 1; i++) { 
                j = i + L - 1; // Set ending index 
  
                // If L is 2, then we just need to 
                // compare two characters. Else need to 
                // check two corner characters and value 
                // of P[i+1][j-1] 
                if (L == 2) 
                    P[i][j] = (str.charAt(i) == str.charAt(j)); 
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1]; 
            } 
        } 
  
        for (i = 0; i < n; i++) { 
            if (P[0][i] == true) 
                C[i] = 0; 
            else { 
                C[i] = Integer.MAX_VALUE; 
                for (j = 0; j < i; j++) { 
                    if (P[j + 1][i] == true && 1 + C[j] < C[i]) 
                        C[i] = 1 + C[j]; 
                } 
            } 
        } 
  
        // Return the min cut value for complete 
        // string. i.e., str[0..n-1] 
        return C[n - 1];
    }
}


/************** */

class Solution {
    public int minCut(String A) {
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }
                else if(g==1){
                    dp[i][j]=A.charAt(i)==A.charAt(j);
                }
                else{
                    if(A.charAt(i)==A.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        
        int[] cut = new int[n];
        cut[0]=0;
        for(int j=1;j<n;j++){
            if(dp[0][j]){
                cut[j]=0;
            }
            else{
                int min = Integer.MAX_VALUE;
                for(int i=j;i>=1;i--){
                        if(dp[i][j]){
                            min = Math.min(min,cut[i-1]);
                        }
                        
                }
                cut[j]=min+1;
            }
        }
        
        return cut[n-1];
    }
}