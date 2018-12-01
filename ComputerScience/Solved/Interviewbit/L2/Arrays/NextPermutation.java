//https://www.interviewbit.com/problems/next-permutation/
//https://www.programcreek.com/2014/06/leetcode-next-permutation-java/

public class Solution {
    public void nextPermutation(ArrayList<Integer> nums) {
    if(nums == null || nums.size()<2){
        return;          
      }
    int p=0;            
    for(int i=nums.size()-2; i>=0; i--){
        if(nums.get(i)<nums.get(i+1)){
            p=i;
            break;
        }    
    }
 
    int q = 0;
    for(int i=nums.size()-1; i>p; i--){
        if(nums.get(i)> nums.get(p)){
            q=i;
            break;
        }    
    }
 
    if(p==0 && q==0){
        reverse(nums, 0, nums.size()-1);
        return;
    }
    
    int temp=nums.get(p);
    nums.set(p,nums.get(q));
    nums.set(q,temp);
 
    if(p<nums.size()-1){
        reverse(nums, p+1, nums.size()-1);
    }

    }
    
    
    public void reverse(ArrayList<Integer> nums, int left, int right){
    while(left<right){
        int temp = nums.get(left);
        nums.set(left,nums.get(right));
        nums.set(right,temp);
        left++;
        right--;
    }
}
}
