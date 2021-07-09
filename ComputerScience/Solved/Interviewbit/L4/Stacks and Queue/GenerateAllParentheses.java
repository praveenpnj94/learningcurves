//https://www.interviewbit.com/problems/generate-all-parentheses/

public class Solution {
    public int isValid(String s) {
        if(s==null||s.length()==0){
            return 1;
        }
        Stack<Character> st = new Stack<>();
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            char c = cs[i];
            if(!belongsToOpen(c)){
                if(st.isEmpty()){
                    return 0;
                }
                char n = st.peek();
                if(!matches(n,c)){
                    return 0;
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
            return 0;
        }
        return 1;
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
