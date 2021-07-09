//https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    //     public int longestConsecutive(int[] nums) {
    //           int max = 0;
    
    //           Set<Integer> set = new HashSet<Integer>();
    //           for (int i = 0; i < nums.length; i++) {
    //             set.add(nums[i]);
    //           }
    
    //           for (int i = 0; i < nums.length; i++) {
    //             int count = 1;
    
    //             // look left
    //             int num = nums[i];
    //             while (set.contains(--num)) {
    //               count++;
    //               set.remove(num);
    //             }
    
    //             // look right
    //             num = nums[i];
    //             while (set.contains(++num)) {
    //               count++;
    //               set.remove(num);
    //             }
    
    //             max = Math.max(max, count);
    //           }
    
    //           return max;
    //     }
        
        
    public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }
    
            int longestStreak = 0;
    
            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;
    
                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }
    
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
    
            return longestStreak;
        }
    }