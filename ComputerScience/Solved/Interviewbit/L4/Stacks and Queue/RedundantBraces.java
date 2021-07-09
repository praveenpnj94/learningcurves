//https://www.interviewbit.com/problems/redundant-braces/
//https://www.youtube.com/watch?v=TsaJeijtKZM&ab_channel=nETSETOS
//https://github.com/varunu28/InterviewBit-Java-Solutions/blob/master/Stacks%20%26%20Queues/Problems/Redundant%20Braces.java

public class Solution {
    public int braces(String A) {
        if(A==null||A.length()==0){
            return 0;
        }
        Stack<Character> st = new Stack<>();
        for(int i =0;i<A.length();i++){
            char c = A.charAt(i);
            if(c=='('||c=='+'||c=='-'||c=='/'||c=='*'){
                st.push(c);
            }
            else if(c==')'){
                char d = st.pop();
                if(d=='('){
                    return 1;
                }
                st.pop();
            }
        }
        return 0;
    }
}
