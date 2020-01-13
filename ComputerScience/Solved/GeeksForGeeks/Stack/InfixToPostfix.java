/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String s = br.readLine();
            System.out.println(infixToPostfix(s));
        }
    }
    public static String infixToPostfix(String s){
        char[] sArray = s.toCharArray();
        String res="";
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<sArray.length;i++){
            char c = sArray[i];
            if(Character.isLetterOrDigit(c)){
                res+=Character.toString(c);
            }
            else if(c=='('){
                st.add(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res+=st.pop();
                }
                if(!st.isEmpty()){
                    st.pop();
                }

            }
            else{
                while(!st.isEmpty() && precedenceOrder(c)<=precedenceOrder(st.peek())){
                    res+=st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
    public static boolean isOperator(char c){
        if((c=='+')||(c=='-')||(c=='*')||(c=='/')){
            return true;
        }
        return false;
    }
    public static int precedenceOrder(char c){
        switch(c){
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            case '^':return 3;
        }
        return -1;
    }
}