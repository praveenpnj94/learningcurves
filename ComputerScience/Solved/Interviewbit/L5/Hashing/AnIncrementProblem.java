//https://www.interviewbit.com/problems/an-increment-problem/

public class Solution {
    public int[] solve(int[] a) {
        int n=a.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],i);
            }
            else{
                int in=map.get(a[i]);
                map.put(a[i],i);
                a[in]++;
                if(!map.containsKey(a[in])||map.get(a[in])>in)
                map.put(a[in],in);
            }
        }
        return a;
    }
}
