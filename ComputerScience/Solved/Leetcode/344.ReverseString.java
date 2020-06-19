//https://leetcode.com/problems/reverse-string/
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/

class Solution {
    public void reverseString(char[] A) {
        int low =0;
        int high = A.length-1;
        while(low<high){
            char temp=A[low];
            A[low]=A[high];
            A[high] = temp;
            low++;
            high--;
        }
    }
}