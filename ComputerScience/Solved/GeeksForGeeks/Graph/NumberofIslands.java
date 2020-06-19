//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?track=PC-W7-GR&batchId=127

    // Initial Template for Java
    
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class Driverclass {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
    
            while (t-- > 0) {
                int N = sc.nextInt();
                int M = sc.nextInt();
    
                ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
    
                // creating arraylist of arraylist
                for (int i = 0; i < N; i++) {
                    ArrayList<Integer> temp = new ArrayList<>(M);
                    list.add(i, temp);
                }
    
                // adding elements to the arraylist of arraylist
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int val = sc.nextInt();
                        list.get(i).add(j, val);
                    }
                }
    
                System.out.println(new Islands().findIslands(list, N, M));
            }
        }
    }
    // } Driver Code Ends
    
    
    // User function Template for Java
    
    class Islands {
        
    
        // Function to find the number of island in the given list
        // N, M: size of list row and column respectively
        static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
            if(list == null || list.size() == 0){
                return 0;
            }
            int ans = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(list.get(i).get(j)==1){
                        ans++;
                        dfs(list,i,j,N,M);
                    }
                }
            }
            return ans;
        }
        
        static void dfs(ArrayList<ArrayList<Integer>> list,int i,int j,int N,int M){
            if(i<0||i>=N||j<0||j>=M||list.get(i).get(j)==0){
                return;
            }
            list.get(i).set(j,0);
            dfs(list,i-1,j,N,M);
            dfs(list,i+1,j,N,M);
            dfs(list,i,j-1,N,M);
            dfs(list,i,j+1,N,M);
            dfs(list,i-1,j-1,N,M);
            dfs(list,i+1,j+1,N,M);
            dfs(list,i-1,j+1,N,M);
            dfs(list,i+1,j-1,N,M);
        }
    }