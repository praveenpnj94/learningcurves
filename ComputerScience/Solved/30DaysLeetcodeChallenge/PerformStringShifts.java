//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
class Solution {
    public String stringShift(String s, int[][] shift) {
        int totalLeftShift = 0;
        int totalRightShift = 0;
        for(int i=0;i<shift.length;i++){
            if(shift[i][0]==0){
                totalLeftShift+=shift[i][1];
            }
            else if(shift[i][0]==1){
                totalRightShift+=shift[i][1];
            }
        }
        if(totalRightShift>totalLeftShift){
            return doRightShift(s,totalRightShift-totalLeftShift);
        }
        else{
            return doLeftShift(s,totalLeftShift-totalRightShift);
        }
    }
    
    public String doRightShift(String s,int k){
        char[] cArr = s.toCharArray();
        int n = cArr.length;
        for(int i=0;i<k;i++){
            char c = cArr[n-1];
            for(int j=n-1;j>0;j--){
                cArr[j]=cArr[j-1];
            }
            cArr[0]=c;
        }
        return new String(cArr);
    }
    
    public String doLeftShift(String s,int k){
        char[] cArr = s.toCharArray();
        int n = cArr.length;
        for(int i=0;i<k;i++){
            char c = cArr[0];
            for(int j=0;j<n-1;j++){
                cArr[j]=cArr[j+1];
            }
            cArr[n-1]=c;
        }
        return new String(cArr);
    }
}
