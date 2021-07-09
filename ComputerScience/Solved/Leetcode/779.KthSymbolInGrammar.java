//https://leetcode.com/problems/k-th-symbol-in-grammar/

class Solution {
    public int kthGrammar(int N, int K) {
        if(K==1){
            return 0;
        }
        if(K==2 && N==2){
            return 1;
        }
        int length = (int)Math.pow(2,N-1);
        if(K<=length/2){
            return kthGrammar(N-1,K);
        }
        else{
            return 1- kthGrammar(N-1,K-(length/2));
        }
    }
}