//https://www.interviewbit.com/problems/maximum-consecutive-gap/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        if(A.size()==1){
            return 0;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<A.size();i++){
            al.add(A.get(i));
        }
        Collections.sort(al);
        int max =Integer.MIN_VALUE;
        for(int j=0;j<al.size()-1;j++){
            max=Math.max(al.get(j+1)-al.get(j),max);
        }
        return max;
    }
}
