//https://www.interviewbit.com/problems/distinct-numbers-in-window/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if(A==null||A.size()==0){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0;
        for(int i=0;i<A.size();i++){
            if(i>=B){
                hm.put(A.get(i-B),hm.getOrDefault(A.get(i-B),0)-1);
                if(hm.get(A.get(i-B))==0){
                    count--;
                }            }
            hm.put(A.get(i),hm.getOrDefault(A.get(i),0)+1);
            if(hm.get(A.get(i))==1){
                count++;
            }
            if(i>=B-1){
                result.add(count);
            }
        }
        return result;
    }
}
