//https://leetcode.com/problems/permutations/
//https://media.geeksforgeeks.org/wp-content/cdn-uploads/NewPermutation.gif

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums==null||nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        helper(result,0,nums);
        return result;
    }
    
    public void helper(List<List<Integer>> result,int start, int[] nums){
        if(start==nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int a:nums){
                curr.add(a);
            }
            result.add(curr);
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            helper(result,start+1,nums);
            swap(nums,i,start);
        }
    }
    
    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }
}