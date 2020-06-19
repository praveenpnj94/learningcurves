//https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
//https://www.geeksforgeeks.org/longest-path-undirected-tree/

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<Integer>());
        }
        int root = -1;
        for(int i=0; i<n; i++) {
            int num = A[i];
            if(num == -1) {
                root = i;
                continue;
            }
            al.get(i).add(num);
            al.get(num).add(i);
        }
        Node s = bfs(0,n,al);
        Node t = bfs(s.val,n,al);
        return t.dist;
    }
    
    public Node bfs(int v, int n, ArrayList<ArrayList<Integer>> al){
        Queue<Integer> q = new LinkedList<Integer>();
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        q.add(v);
        arr[v]=0;
        while(!q.isEmpty()){
            int temp = q.poll();
            ArrayList<Integer> a = al.get(temp);
            for(int el:a){
                if(arr[el]==-1){
                    q.add(el);
                    arr[el]=arr[temp]+1;
                }
            }
            
        }
        int maxDist = 0;
        int maxVal = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxDist){
                maxDist=arr[i];
                maxVal=i;
            }
        }
        return new Node(maxVal,maxDist);
    }
}

        class Node{
            int val;
            int dist;
            Node(int val, int dist){
                this.val = val;
                this.dist = dist;
            }
        }
