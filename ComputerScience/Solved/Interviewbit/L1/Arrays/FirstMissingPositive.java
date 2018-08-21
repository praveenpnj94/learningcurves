//https://www.interviewbit.com/problems/first-missing-integer/
//http://theoryofprogramming.com/2017/12/17/first-missing-integer-unsorted-array/
//https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> a) {
        final int N = a.size();     // size
        // a dummy value to replace
        // integers below 0 and above N
        final int FLAG = N + 2; 
         
        for (int i = 0; i < N; ++i) {
            if (a.get(i) <= 0 || a.get(i) > N) {
                a.set(i, FLAG);
            }
        }
         
        // Our formula loop
        for (int i = 0; i < N; ++i) {
            if (a.get(i) == FLAG || a.get(i) == -FLAG) {
                continue;
            }
             
            int value = Math.abs(a.get(i));
                 
            a.set(value - 1, -Math.abs(a.get(value - 1)));
        }
         
        // Loop through collection. Whichever
        // index holds a +ve integer is the answer
        for (int i = 0; i < N; ++i) { if (a.get(i) > 0) {
                return i + 1;
            }
        }
         
        // If the collection has all integers
        // from 1 to N, then answer is N + 1
        return N + 1;     
    }
}
