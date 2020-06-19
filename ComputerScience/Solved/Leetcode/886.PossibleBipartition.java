//https://leetcode.com/problems/possible-bipartition/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
//https://leetcode.com/problems/possible-bipartition/discuss/655367/Java-BFS-Solution-Video-Tutorial

//BFS

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = constructGraph(N, dislikes);
        return bfs(N, graph);
    }

    private boolean bfs(int N, List<Integer>[] graph) {
        int[] colors = new int[N]; // default value 0 = not colored yet, 1 = group1, -1 = group2
        for (int i = 0; i < N; i++) {
            if (colors[i] != 0) // already colored
                continue;

            colors[i] = 1;
            Queue<Integer> queue = new LinkedList();
            queue.add(i);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                for (int adjVertex : graph[currentVertex]) {
                    if (colors[adjVertex] == colors[currentVertex])
                        return false;
                    if (colors[adjVertex] == 0) {
                        colors[adjVertex] = -colors[currentVertex];
                        queue.add(adjVertex);
                    }
                }
            }
        }

        return true;
    }

    // build the graph from N vertices and edges
    private List<Integer>[] constructGraph(int N, int[][] edges) {
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }
}


//DFS

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = constructGraph(N, dislikes);
        return dfs(N, graph);
    }

    private boolean dfs(int N, List<Integer>[] graph) {
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !dfsUtil(graph, colors, i, 1))
                return false;
        }

        return true;
    }

    private boolean dfsUtil(List<Integer>[] graph, int[] colors, int currentVertex, int color) {
        if (colors[currentVertex] != 0)
            return colors[currentVertex] == color;
        colors[currentVertex] = color;
        for (int adjVertex : graph[currentVertex]) {
            if (!dfsUtil(graph, colors, adjVertex, -color))
                return false;
        }

        return true;
    }

    // build the graph from N vertices and edges
    private List<Integer>[] constructGraph(int N, int[][] edges) {
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }
}