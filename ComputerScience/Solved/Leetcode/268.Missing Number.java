//https://leetcode.com/problems/missing-number/

// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         if(nums.length==1){
//             if(nums[0]==0){
//                 return 1;
//             }
//             else{
//                 return 0;
//             }
//         }
//         for(int i=1;i<nums.length;i++){
//             if(nums[0]!=0){
//                 return 0;
//             }
//             if(nums[i]-nums[i-1]>1){
//                 return nums[i-1]+1;
//             }
//         }
//         return nums[nums.length-1]+1;
//     }
// }

// class Solution {
//     public int missingNumber(int[] nums) {
//         int expectedSum = nums.length*(nums.length + 1)/2;
//         int actualSum = 0;
//         for (int num : nums) actualSum += num;
//         return expectedSum - actualSum;
//     }
// }

// class Solution {
//     public int missingNumber(int[] nums) {
//         Set<Integer> numSet = new HashSet<Integer>();
//         for (int num : nums) numSet.add(num);

//         int expectedNumCount = nums.length + 1;
//         for (int number = 0; number < expectedNumCount; number++) {
//             if (!numSet.contains(number)) {
//                 return number;
//             }
//         }
//         return -1;
//     }
// }


class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
