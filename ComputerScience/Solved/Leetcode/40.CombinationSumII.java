//https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates,result,new ArrayList<>(), target,0);
        return result;
    }
    
    public void helper(int[] candidates, List<List<Integer>> result,List<Integer> item, int remain,int start){
        if(remain<0){
            return;
        }
        else if(remain==0){
            result.add(new ArrayList<>(item));
        }
        else{
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1]){
                    continue;
                }
                item.add(candidates[i]);
                helper(candidates,result,item, remain-candidates[i],i+1);
                item.remove(item.size()-1);
            }
        }
    }
}