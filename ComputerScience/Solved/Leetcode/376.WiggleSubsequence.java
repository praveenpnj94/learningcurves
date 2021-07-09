//https://leetcode.com/problems/wiggle-subsequence/
//https://www.youtube.com/watch?v=xtDu3jm5WsI&ab_channel=alGOds

// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         if (nums.length < 2) return nums.length;
//         int maxLen = 1;
//         int sign = 0;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] < nums[i-1] && sign != -1) {         //peak
//                 sign = -1;
//                 maxLen++;
//             } else if (nums[i] > nums[i-1] && sign != 1) {   //valley
//                 sign = 1;
//                 maxLen++;
//             }
//         }
//         return maxLen;
//     }
// }

// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         if (nums.length < 2) return nums.length;
//         int up = 1;
//         int down = 1;
        
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > nums[i - 1]) {
//                 up = down + 1;
//             }
//             else if (nums[i] < nums[i - 1]) {
//                 down = up + 1;
//             }
//         }
        
//         return Math.max(up, down); 
//     }
// }


// public class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         if (nums.length < 2)
//             return nums.length;
//         int[] up = new int[nums.length];
//         int[] down = new int[nums.length];
//         for (int i = 1; i < nums.length; i++) {
//             for(int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) {
//                     up[i] = Math.max(up[i],down[j] + 1);
//                 } else if (nums[i] < nums[j]) {
//                     down[i] = Math.max(down[i],up[j] + 1);
//                 }
//             }
//         }
//         return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
//     }
// }



public class Solution {
    private static enum Direction {
          INCREASING, DECREASING;
      }  
    
      public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
          return nums.length;
        }
        int maxLen = 1;
        Direction direction = null;
    
        for (int i = 1; i < nums.length; i++) {
          // If it was decreasing and our current number is now bigger than previous, 
          // we have a valley at the previous number.
          // Example: [5,4,3(valley),9]  
          if (nums[i] > nums[i - 1] &&
              (direction == null || direction == Direction.DECREASING)) {
            direction = Direction.INCREASING;
            maxLen++;
          }
          // If it was increasing and our current number is now smaller than previous, 
          // we have a peak at the previous number.
          // Example: [1,2,5(peak),0]  
          else if (nums[i] < nums[i - 1] &&
              (direction == null || direction == Direction.INCREASING)) {
            direction = Direction.DECREASING;
            maxLen++;
          }
        }
    
        return maxLen;
      }
}