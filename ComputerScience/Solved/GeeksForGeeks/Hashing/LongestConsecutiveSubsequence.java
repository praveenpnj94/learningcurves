//https://leetcode.com/problems/longest-consecutive-sequence/solution/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            System.out.println(longestConsecutiveEfficient(a));
        }
    }
    public static int longestConsecutive(int[] a, int n){
        Arrays.sort(a);
        int maxLength=1;
        for(int i=0;i<n;i++){
            int length = 1;
            for(int j=i;j<n-1;j++){
                if(Math.abs(a[j]-a[j+1])==1){
                    length++;
                }
                else if(Math.abs(a[j]-a[j+1])==0){
                    
                }
                else{
                    break;
                }
            }
            maxLength=Math.max(length,maxLength);
        }
        return maxLength;
    }
    public static int longestConsecutiveEfficient(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
    public static int longestConsecutive3(int[] nums) {
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