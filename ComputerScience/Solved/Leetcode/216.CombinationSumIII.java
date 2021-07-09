//https://leetcode.com/problems/combination-sum-iii/
//https://www.youtube.com/watch?v=s_L0AuKaqXo&ab_channel=PrakashShukla

class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(k, target, 1, currentList, res);
        return res;
    }
    
    public void dfs(int k, int target, int idx, List<Integer> currentList, List<List<Integer>> res){
        
        if(currentList.size()==k)
        {
            if(target==0){
                res.add(new ArrayList(currentList));
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            currentList.add(i);
            dfs(k, target-i, i+1, currentList, res);
            currentList.remove(currentList.size()-1);
        }   
    }
}