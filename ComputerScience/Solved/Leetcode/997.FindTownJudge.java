//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
//https://leetcode.com/problems/find-the-town-judge/

//My Solution

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==1){
            return 1;
        }
        boolean[] res = new boolean[N+1];
        HashMap<Integer,Integer> m = new HashMap<>();
        Arrays.fill(res,true);
        res[0]=false;
        for(int i=0;i<trust.length;i++){
            res[trust[i][0]]=false;
            m.put(trust[i][1],m.getOrDefault(trust[i][1],0)+1);
        }
        for(int j=0;j<=N;j++){
            if(res[j]){
                if(m.containsKey(j)){
                    if(m.get(j)==N-1){
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    //leetcode solution

public int findJudge2(int N, int[][] trust) {
    
    if (trust.length < N - 1) {
        return -1;
    }
    
    int[] indegrees = new int[N + 1];
    int[] outdegrees = new int[N + 1];

    for (int[] relation : trust) {
        outdegrees[relation[0]]++;
        indegrees[relation[1]]++; 
    }

    for (int i = 1; i <= N; i++) {
        if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
            return i;
        }
    }
    return -1;
}
}