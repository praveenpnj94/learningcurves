//https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/

public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>() ;
        
        TreeSet<Integer> set = new TreeSet<>() ;
        set.add(A) ;
        set.add(B) ;
        set.add(C) ;
        
        for(int i = 0; i < D; i++) {
            int temp = set.first() ;
            set.remove(temp) ;
            res.add(temp) ;
            
            set.add(temp*A) ;
            set.add(temp*B) ;
            set.add(temp*C) ;
            
        }
        return res ;
    }
}