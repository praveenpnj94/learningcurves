//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
//https://www.youtube.com/watch?v=Zb4eRjuPHbM
//https://leetcode.com/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        int lastGoodPos = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(i+nums[i]>=lastGoodPos){
                lastGoodPos = i;
            }
        }
        return lastGoodPos==0;
        
    }

    public boolean canJump2(int[] A) {
        if(A.length <= 1)
            return true;
     
        int max = A[0]; //max stands for the largest index that can be reached.
     
        for(int i=0; i<A.length; i++){
            //if not enough to go to next
            if(max <= i && A[i] == 0) 
                return false;
     
            //update max    
            if(i + A[i] > max){
                max = i + A[i];
            }
     
            //max is enough to reach the end
            if(max >= A.length-1) 
                return true;
        }
     
        return false;    
    }
}



//Backtracking
public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}

//TopDownDP
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
}

//BottomUpDP
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}