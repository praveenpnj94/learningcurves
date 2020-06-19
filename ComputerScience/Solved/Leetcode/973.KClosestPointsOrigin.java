//https://leetcode.com/problems/k-closest-points-to-origin/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
//https://www.youtube.com/watch?v=1rEUgAG7f_c

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int m = points.length;
        int n = points[0].length; 
        List<Node> list = new ArrayList<Node>();
        for(int[] p:points){
            int distSquare = p[0]*p[0] + p[1]*p[1];
            list.add(new Node(distSquare,p));
        }
        Collections.sort(list,new NodeComparator());
        int[][] l = new int[K][n];
        for(int i=0;i<K;i++){
            Node temp = list.get(i);
            int[] t = temp.point;
            l[i][0]=t[0];
            l[i][1]=t[1];
        }
        return l;
    }
}
class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node n1, Node n2){
        return n1.dist-n2.dist;
    }
}
class Node{
        int dist;
        int[] point;
        Node(int dist, int[] point){
            this.dist = dist;
            this.point = point;
        }
}