//https://www.interviewbit.com/problems/compare-version-numbers/

import java.math.BigInteger; 
public class Solution {
    public int compareVersion(String A, String B) {
        String[] first = A.split("\\.");
        String[] second = B.split("\\.");
        int length = Math.min(first.length,second.length);
        for(int i=0;i<length;i++){
            BigInteger a=new BigInteger(first[i]);
            BigInteger b=new BigInteger(second[i]);
            if(a.compareTo(b)==1){
                return 1;
            }
            else if(b.compareTo(a)==1){
                return -1;
            }
            else{
                
            }
        }
        if(second.length>length && Long.parseLong(second[length])!=0){
            return -1;
        }
        else if(first.length>length && Long.parseLong(first[length])!=0){
            return 1;
        }
        else{
            return 0;   
        }
    }
}
