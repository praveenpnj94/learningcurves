//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if(low>high){
            return 0;
        }
        else if(low==high){
            return low%2==1?1:0;
        }
        else{
            int s=low%2==1?low:low+1;
            int e=high%2==1?high:high-1;
            return (e-s)/2 +1;
        }
    }
}