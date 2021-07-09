//https://www.interviewbit.com/problems/check-palindrome/

public class Solution {
    public int solve(String A) {
        if(A==null||A.length()==0){
            return 0;
        }
        char[] aArr=A.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:aArr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int oneCnt=0;
        for(char c:map.keySet()){
            if(A.length()%2==0){
                if(map.get(c)%2!=0){
                    return 0;
                }
            }
            else{
                if(map.get(c)%2!=0){
                    oneCnt++;
                }
            }
        }
        if(A.length()%2!=0 && oneCnt>1){
            return 0;
        }
        return 1;
    }
}
