//https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/

public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<B.size();i++){
            adj.get(B.get(i)-1).add(C.get(i)-1);
        }
        if(isCyclic(adj,A)){
            return 0;
        }
        return 1;
    }
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int A){
        boolean[] vis = new boolean[A];
        boolean[] rec = new boolean[A];
        for(int i=0;i<A;i++){
            if(!vis[i]){
                if(dfs(i,adj,A,vis,rec)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int s, ArrayList<ArrayList<Integer>> adj, int A, boolean[] vis, boolean[] rec){
        vis[s] =true;
        rec[s]=true;
        ArrayList<Integer> al = adj.get(s);
        for(Integer a:al){
            if(!vis[a]){
                if(dfs(a,adj,A,vis,rec)){
                    return true;
                }
            }
            else if(rec[a]){
                return true;
            }
        }
        rec[s]=false;
        return false;
    }
}
