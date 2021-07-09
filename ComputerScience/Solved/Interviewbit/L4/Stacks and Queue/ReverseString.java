//https://www.interviewbit.com/problems/reverse-string/

public class Solution {
    public String reverseString(String A) {
        if(A==null||A.length()==0||A.length()==1){
            return A;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i<A.length();i++){
            st.push(A.charAt(i));
        }
        String s="";
        while(!st.isEmpty()){
            Character c = st.peek();
            st.pop();
            s+=Character.toString(c);
        }
        return s;
    }
}
