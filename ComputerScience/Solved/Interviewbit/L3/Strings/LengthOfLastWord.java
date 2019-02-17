//https://www.interviewbit.com/problems/length-of-last-word/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        String[] arr = A.split("\\s+");
        if(arr.length==0){
            return 0;
        }
        return arr[arr.length-1].length();
    }
}