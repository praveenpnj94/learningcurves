//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1/?track=PC-W7-GR&batchId=127
//https://www.youtube.com/watch?v=RpgcYiky7uw
class Solution
{
    public int kosaraju(ArrayList<ArrayList<Integer>> list, int N)
    {
        boolean[] visited=new boolean[N];
        List<Integer> order=fillOrder(list,visited,N);
        ArrayList<ArrayList<Integer>> reverse=getTranspose(list,N);
        visited=new boolean[N];
        Collections.reverse(order);
        List<List<Integer>> SCC=new ArrayList<>();
        for(int i=0;i<order.size();i++){
            int v=order.get(i);
            if(!visited[v]){
                List<Integer> comp=new ArrayList<>();
                DFS(reverse,v,visited,comp);
                SCC.add(comp);
            }
        }
        return SCC.size()-1;
    }
    static List<Integer> fillOrder(ArrayList<ArrayList<Integer>> graph,boolean[] visited,int N){
        List<Integer> order=new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        if(!visited[i])
        DFS(graph,i,visited,order);
        return order;
    }
    static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> graph,int N){
        ArrayList<ArrayList<Integer>> g=new ArrayList<>();
        for(int i=0;i<N;i++)
        g.add(i,new ArrayList<Integer>());
        for(int v=0;v<N;v++)
        for(int i=0;i<graph.get(v).size();i++)
        g.get(graph.get(v).get(i)).add(v);
        return g;
    }
    static void DFS(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, List<Integer> comp) 
    {
        visited[v]=true;
        for(int i=0;i<graph.get(v).size();i++)
        if(!visited[graph.get(v).get(i)])
                DFS(graph, graph.get(v).get(i), visited, comp);
        comp.add(v);
    }
}