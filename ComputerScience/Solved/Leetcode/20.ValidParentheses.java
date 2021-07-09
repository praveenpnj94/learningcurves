//https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        Stack<Character> st = new Stack<>();
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            char c = cs[i];
            if(!belongsToOpen(c)){
                if(st.isEmpty()){
                    return false;
                }
                char n = st.peek();
                if(!matches(n,c)){
                    return false;
                }
                else{
                    st.pop();
                }
            }
            else{
                st.push(c);
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean belongsToOpen(char c){
        return c=='{'|| c=='('|| c=='[';
    }
    public boolean matches(char o,char c){
        if(o=='(' && c==')'){
            return true;
        }
        else if(o=='{' && c=='}'){
            return true;
        }
        else if(o=='[' && c==']'){
            return true;
        }
        return false;
    }
}