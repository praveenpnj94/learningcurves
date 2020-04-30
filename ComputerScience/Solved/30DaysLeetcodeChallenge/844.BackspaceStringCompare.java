//https://leetcode.com/problems/backspace-string-compare/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] a = S.toCharArray();
        char[] b = T.toCharArray();
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for(int i=0;i<a.length;i++){
            char c =a[i];
            if(c=='#'){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else{
                s.push(c);
            }
        }
        for(int j=0;j<b.length;j++){
            char c =b[j];
            if(c=='#'){
                if(!t.isEmpty()){
                    t.pop();
                }
            }
            else{
                t.push(c);
            }
        }
        if(s.isEmpty()&&t.isEmpty()){
            return true;
        }
        else{
            if(s.size()!=t.size()){
                return false;
            }
            else{
                while(!s.isEmpty() && !t.isEmpty()){
                    if(s.pop()!=t.pop()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}