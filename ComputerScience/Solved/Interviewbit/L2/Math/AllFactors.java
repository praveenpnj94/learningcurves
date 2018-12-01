//https://www.interviewbit.com/problems/all-factors/

public class Solution {
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(A==1){
            l.add(1);
        }
        else{
            for(int i=1;i<=Math.sqrt(A);i++){
            if(A%i==0){
                l.add(i);
                if(i!=A/i){
                    l.add(A/i);                    
                }
            }
        }
        Collections.sort(l);   
        }
        return l;
    }
}
