//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/

class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0;
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(map.containsKey(num)){
                int cnt = map.get(num);
                map.put(num,cnt+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(int j=0;j<arr.length;j++){
            int key = arr[j];
            if(map.containsKey(key+1)){
                int cnt = map.get(key+1);
                if(cnt>=1){
                    count++;
                    //map.put(key+1,cnt-1);
                }
            }
        }
        return count;
    }
}