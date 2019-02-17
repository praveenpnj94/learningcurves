//https://www.interviewbit.com/problems/reverse-the-string/

public class Solution {
    public String reverseWords(String a) {
        String[] arr = a.split("\\s+");
        if(arr.length<=1){
            return a;
        }
        String reversedString="";
        for(int i=0;i<arr.length;i++){
            reversedString+=arr[arr.length-i-1];
            if(i!=arr.length-1){
                reversedString+=" ";
            }
        }
        return reversedString;
    }
}
