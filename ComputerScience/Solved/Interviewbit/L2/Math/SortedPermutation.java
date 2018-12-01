//https://www.interviewbit.com/problems/sorted-permutation-rank/
//https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/

public class Solution {
    public int fact(int a){
        if(a==0||a==1){
            return 1;
        }
        return (a*(fact(a-1)))%m;
    }
    public int m = 1000003;
    public int findRank(String A) {
        int n = A.length();
        if(n==0||n==1){
            return 1;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            int c = (int)A.charAt(i);
            int temp = 0;
            for(int j=i+1;j<n;j++){
                if(c>(int)A.charAt(j)){
                    temp++;
                }
            }
            count += temp*(fact(n-i-1));
            count %=m;
        }
        return count+1;
    }
}
