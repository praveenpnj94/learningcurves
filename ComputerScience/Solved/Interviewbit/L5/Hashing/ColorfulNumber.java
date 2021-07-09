//https://www.interviewbit.com/problems/colorful-number/

public class Solution {
    public int colorful(int A) {
        String s = Integer.toString(A);
        HashSet<Long> hs = new HashSet<>();
        for(int i=0;i<s.length();i++){
            long prod =1;
            for(int j=i;j<s.length();j++){
                prod*=(s.charAt(j)-'0');
                if(hs.contains(prod)){
                    return 0;
                }
                else{
                    hs.add(prod);
                }
            }
        }
        return 1;
    }
}
