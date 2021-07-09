//https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int s1 = value(s.charAt(i));
            if(i+1<n){
                int s2 = value(s.charAt(i+1));
                if(s1>=s2){
                    res+=s1;  
                }
                else{
                    res+=s2-s1;
                    i++;
                }
            }
            else{
                res+=s1;
                i++;
            }
        }
        return res;
    }
    public int value(char c){
        int num = 0;
        switch(c){
            case 'I':
            num = 1;
            break;  
            case 'V':
            num = 5;
            break; 
            case 'X':
            num = 10;
            break;
            case 'L':
            num = 50;
            break; 
            case 'C':
            num = 100;
            break;
            case 'D':
            num = 500;
            break;
            case 'M':
            num = 1000;
            break;
            default:
            num =-1;
        }
        return num;
    }
}