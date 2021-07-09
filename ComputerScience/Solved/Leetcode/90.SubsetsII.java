//https://leetcode.com/problems/subsets-ii/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums==null||nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(),0,nums);
        return result;
    }
    
    
    public void helper(List<List<Integer>> result, List<Integer> item, int start, int[] nums){
        result.add(new ArrayList<Integer>(item));
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            item.add(nums[i]);
            helper(result, item,i+1,nums);
            item.remove(item.size()-1);
        }
    }
}