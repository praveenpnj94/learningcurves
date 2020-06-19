//https://www.youtube.com/watch?v=SiDMFIMldgg
//https://leetcode.com/problems/first-bad-version/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left=1;
            int right =n;
            int result = n;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(isBadVersion(mid)){
                    result = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            return result;
        }
    }