//https://leetcode.com/problems/course-schedule-ii/
//https://www.youtube.com/watch?v=HcRo3BFV8-M&list=PLk3HmtBxW9XVBUSi5EeFxKAlNncAJKcjV&index=5

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    Stack<Integer> stk;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        stk = new Stack<>();        
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i)){
                    return new int[]{};
                }
            }
        }
        
        int[] res = new int[stk.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stk.pop();
        }
        
        return res; 
    }
    
    public boolean dfs(int i){
        visited[i] = true;
        for(Integer j : graph[i]){
            if(!visited[j]){
                if(dfs(j)){
                    return true;
                }
            }
            else if(!explored[j]){
                return true;
            }
        }
        explored[i] = true;
        stk.push(i);
        return false;
    }
}