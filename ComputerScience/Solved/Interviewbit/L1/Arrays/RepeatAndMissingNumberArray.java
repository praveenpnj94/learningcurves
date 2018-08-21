//https://www.interviewbit.com/problems/repeat-and-missing-number-array/
//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
    ArrayList<Integer> ret = new ArrayList<>();
    int xor = 0, x = 0, y = 0;
    for(int i=0; i<A.size(); i++) {
        xor ^= A.get(i);
    }
    for(int i=1; i<=A.size(); i++) {
        xor ^= i;
    }

    int setBit = xor & ~(xor-1);
    for(int i=0; i<A.size(); i++) {
        if((A.get(i) & setBit) != 0) {
            x ^= A.get(i);
        } else {
            y ^= A.get(i);
        }
    }
    for(int i=1; i<=A.size(); i++) {
        if((i & setBit) != 0) {
            x ^= i;
        } else {
            y ^= i;
        }
    }

    for(int i=0; i<A.size(); i++) {
        if(A.get(i) == x) {
            ret.add(x);
            ret.add(y);
            return ret;
        } 

        if(A.get(i) == y) {
            ret.add(y);
            ret.add(x);
            return ret;
        }
    }

    return ret;
    }
}
