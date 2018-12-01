//https://www.interviewbit.com/problems/implement-power-function/

public class Solution {
    public int pow(int x, int n, int d) {
        if(n==0){
            return x==0?0:1;
        }else if(n==1){
            x = x%d;
            if(x<0){
                x += d;
            }
            return x;
        }
        long smaller = pow(x,n/2,d);
        long result = (smaller*smaller)%d;
        if(result<0){
            result += d;
        }
        if(n%2!=0){
            result = (result*x)%d;
            if(result<0){
                result+=d;
            }
        }
        return (int)(result%d);
    }
}
