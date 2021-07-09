//https://www.interviewbit.com/problems/generate-all-parentheses-ii/

public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        if(A==0){
            return new ArrayList<String>();
        }
        ArrayList<String> al = new ArrayList<String>();
        helper(al,A-1,A,"(");
        return al;
    }
    
    public void helper(ArrayList<String> al,int open, int closed, String curr){
        if(open==0 && closed==0){
            al.add(curr);
            return;
        }
        if(open>0){
            helper(al,open-1,closed,curr+"(");
        }
        if(closed>0 && closed>open){
            helper(al,open,closed-1,curr+")");
        }
    }
}