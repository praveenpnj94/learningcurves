//https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums==null||nums.length==0){
            return result;
        }
        helper(result, new ArrayList<Integer>(),0,nums);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int start, int[] nums){
        result.add(new ArrayList<Integer>(item));
        for(int i=start;i<nums.length;i++){
            item.add(nums[i]);
            helper(result, item,i+1,nums);
            item.remove(item.size()-1);
        }
    }
}