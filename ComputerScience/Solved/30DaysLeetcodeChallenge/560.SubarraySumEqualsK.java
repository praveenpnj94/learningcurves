//https://leetcode.com/problems/subarray-sum-equals-k/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

class GFG
{
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[])
    {
        int[] arr = {3,4,7,2,-3,1,4,2};
        System.out.println(subarraySum(arr,7));
    }
}
