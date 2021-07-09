//https://leetcode.com/problems/string-compression/
//https://www.youtube.com/watch?v=IhJgguNiYYk&ab_channel=KevinNaughtonJr.

class Solution {
    public int compress(char[] chars) {
        int i=0;
        int index=0;
        if(chars==null||chars.length==0){
            return 0;
        }
        while(i<chars.length){
            int j=i;
            while(j<chars.length && chars[j]==chars[i]){
                j++;
            }
            chars[index++]=chars[i];         
            if(j-i>1){
                String count = j-i+"";
                for(char c:count.toCharArray()){
                    chars[index++]=c;
                }
            }
            i=j;
        }
        return index;
    }
}