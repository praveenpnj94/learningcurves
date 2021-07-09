//https://www.interviewbit.com/problems/subarray-with-b-odd-numbers/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
                int oddCount = 0;//For storing count of odd number till ith index
        int subArrayCount = 0;//For storing the count of subArray with B odd numbers
        //map for storing the count of arrays
        //starting from 0th index with key as odd number count
        HashMap<Integer, Integer> oddCountMap = new HashMap<Integer, Integer>();
        oddCountMap.put(0,1);
        for (int i=0;i<A.size();i++){
            if (A.get(i) % 2 != 0){
                oddCount++;
            }
            subArrayCount += oddCountMap.getOrDefault(oddCount-B,0);
            oddCountMap.put(oddCount, oddCountMap.getOrDefault(oddCount,0)+1);
        }
        return subArrayCount;
    }
}
