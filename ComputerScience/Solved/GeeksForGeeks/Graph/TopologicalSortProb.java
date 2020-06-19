// { Driver Code Starts

    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
    
            while (t-- > 0) {
                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                String st[] = read.readLine().trim().split("\\s+");
                int edg = Integer.parseInt(st[0]);
                int nov = Integer.parseInt(st[1]);
    
                for (int i = 0; i < nov + 1; i++)
                    list.add(i, new ArrayList<Integer>());
    
                String s[] = read.readLine().trim().split("\\s+");
                int p = 0;
                for (int i = 1; i <= edg; i++) {
                    int u = Integer.parseInt(s[p++]);
                    int v = Integer.parseInt(s[p++]);
                    list.get(u).add(v);
                }
    
                int[] res = new TopologicalSort().topoSort(list, nov);
    
                if (check(list, nov, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
        static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
            int[] map = new int[V];
            for (int i = 0; i < V; i++) {
                map[res[i]] = i;
            }
            for (int i = 0; i < V; i++) {
                for (int v : list.get(i)) {
                    if (map[i] > map[v]) return false;
                }
            }
            return true;
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    
    /*
    ArrayList<ArrayList<>Integer>list: to represent graph containing 'N' vertices
                                        and edges between them
    N: represent number of vertices
    */
    class TopologicalSort {
        static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
            boolean[] vis = new boolean[N];
            int[] res = new int[N];
            Arrays.fill(vis,false);
            Stack<Integer> sc = new Stack<>();
            for(int i =0;i<N;i++){
                if(!vis[i]){
                    dfs(i,vis,sc,list);                
                }
            }
            int j=0;
            while(!sc.isEmpty()){
                res[j]=sc.pop();
                j++;
            }
            return res;
        }
        static void dfs(int s,boolean[] vis,Stack<Integer> sc,ArrayList<ArrayList<Integer>> list){
            vis[s]=true;
            ArrayList<Integer> al = list.get(s);
            for(int i=0;i<al.size();i++){
                int n = al.get(i);
                if(!vis[n]){
                    dfs(n,vis,sc,list);
                }
            }
            sc.push(s);
        }
    }