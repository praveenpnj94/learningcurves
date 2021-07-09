//https://www.interviewbit.com/problems/simplify-directory-path/

public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0){
            return path;
        }
        Stack<String> st = new Stack<>();
        String[] p = path.split("/");
        for(String s:p){
            if(!st.isEmpty() && s.equals("..")){
                st.pop();
            }
            else if(!s.equals("") && !s.equals(".") && !s.equals("..")){
                st.push(s);
            }
        }
        return "/"+String.join("/",st);
    }
}
