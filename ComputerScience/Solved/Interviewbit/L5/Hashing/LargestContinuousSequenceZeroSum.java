//https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/


public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        int start = 0, end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if(map.containsKey(sum)) {
                int currStart = map.get(sum),
                    currEnd = i;
                if(currEnd - currStart + 1 > end - start + 1) {
                    start = currStart;
                    end = currEnd;
                }
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        //System.out.println(map);
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = start + 1; i <= end; i++) {
            result.add(a.get(i));
        }
        return result;
    }
}

