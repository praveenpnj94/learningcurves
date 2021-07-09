//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null||numbers.length==0){
            return numbers;
        }
        int l = 0;
        int h = numbers.length-1;
        while(l<h){
            if(numbers[l]+numbers[h]==target){
                int[] res = new int[2];
                res[0]=l>h?h+1:l+1;
                res[1]=l>h?l+1:h+1;
                return res;
            }
            else if(numbers[l]+numbers[h]<target){
                l++;
            }
            else{
                h--;
            }
        }
        return new int[2];    
    }
}