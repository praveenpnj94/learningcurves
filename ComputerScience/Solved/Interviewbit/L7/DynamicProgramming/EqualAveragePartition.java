//https://www.interviewbit.com/problems/equal-average-partition/
//https://www.youtube.com/watch?v=VwylCVAVdmo&t=324s&ab_channel=takeUforward

public class Solution {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        if(n==0){
            return res;
        }
        int totalSum = 0;
        for(int num:A){
            totalSum+=num;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        boolean[][][] dp = new boolean[n][n][totalSum+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=totalSum;k++){
                    dp[i][j][k]=true;
                }
            }
        }
        ArrayList<Integer> pre = new ArrayList<>();
        pre.clear();
        for(int i=1;i<=n-1;i++){
            if((totalSum*i)%n==0){
                int ss = totalSum*i;
                ss = ss/n;
                if(check(0,i,ss,dp,pre,A)){
                    res.add(pre);
                    break;
                }
            }
        }
        
        ArrayList<Integer> post = new ArrayList<>();
        if(pre.size()==0){
            return res;
        }
        for(int no:pre){
            map.put(no,map.get(no)-1);
        }
        
        for(int val:map.keySet()){
            if(map.get(val)>0){
                int v = map.get(val);
                for(int i=0;i<v;i++){
                    post.add(val);
                }
            }
        }
        
        res.add(post);
        return res;
    }
    
    public boolean check(int idx, int ele, int sum, boolean[][][] dp, ArrayList<Integer> pre, ArrayList<Integer> A){
        
        if(ele==0){
            return sum==0;
        }
        if(idx>=A.size()){
            return false;
        }
        
        if(dp[idx][ele][sum]==false){
            return false;
        }
        
        if(A.get(idx)<=sum){
            pre.add(A.get(idx));
            if(check(idx+1,ele-1,sum-A.get(idx),dp,pre,A)){
                return dp[idx][ele][sum]=true;
            }
            pre.remove(pre.size()-1);
        }
        
        if(check(idx+1,ele,sum,dp,pre,A)){
            return dp[idx][ele][sum]=true;
        }
        
        return dp[idx][ele][sum]=false;
    }
}
