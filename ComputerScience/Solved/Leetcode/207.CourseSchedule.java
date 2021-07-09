//https://leetcode.com/problems/course-schedule/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
//https://www.youtube.com/watch?v=CL4NZAoOdpM&ab_channel=AkshayGoyal
//DFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int[] p:prerequisites){
            list.get(p[1]).add(p[0]);
        }
        if(isCyclic(list,numCourses)){
            return false;
        }
        return true;
    }
    
    boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
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
        
    boolean dfs(int s,ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] rec){
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

//topo

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int[] pair:prerequisites){
            indegree[pair[1]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int select = 0;
        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();
            for(int[] pair:prerequisites){
                if(pair[0]==course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]]==0){
                        queue.add(pair[1]);
                    }
                }
            }
        }
        return numCourses==0;
    }
}