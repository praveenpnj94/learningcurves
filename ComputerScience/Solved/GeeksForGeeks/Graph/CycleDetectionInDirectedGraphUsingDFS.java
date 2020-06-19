//https://www.youtube.com/watch?v=joqmqvHC_Bo
//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/?ref=rp
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/?track=PC-W7-GR&batchId=127

// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass
    {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                int nov = sc.nextInt();
                int edg = sc.nextInt();
                for(int i = 0; i < nov+1; i++)
                    list.add(i, new ArrayList<Integer>());
                for(int i = 1; i <= edg; i++)
                {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    list.get(u).add(v);
                }
                if(new DetectCycle().isCyclic(list, nov) == true)
                    System.out.println("1");
                else System.out.println("0");
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    
    /*
    ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                        vertices and edges between them
    V: represent number of vertices
    */
    class DetectCycle
    {
        static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
        {
           boolean[] visited=new boolean[V];
           boolean[] rec = new boolean[V];
           Arrays.fill(visited,false);
           Arrays.fill(rec,false);
           for(int i=0;i<V;i++){
               if(!visited[i]){
                    if(dfs(i,list,visited,rec)){
                        return true;
                    }               
               }
           }
           return false;
        }
        
        static boolean dfs(int s,ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] rec){
            visited[s]=true;
            rec[s]=true;
            ArrayList<Integer> al = list.get(s);
            for(int i=0;i<al.size();i++){
                int n = al.get(i);
                if(!visited[n]){
                    if(dfs(n,list,visited,rec)){
                        return true;
                    }  
                }
                else if(rec[n]){
                    return true;
                }
            }
            rec[s]=false;
            return false;
        }
    }