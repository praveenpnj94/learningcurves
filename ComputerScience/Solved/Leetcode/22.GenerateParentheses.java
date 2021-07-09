//https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        helper(result,n-1,n,"(");
        return result;
    }
    
    public void helper(List<String> result,int open, int closed,String op){
        if(open==0 && closed==0){
            result.add(op);
            return;
        }
        if(open>0){
            helper(result,open-1,closed,op+"(");
        }
        if(closed>0 && closed>open){
            helper(result,open,closed-1,op+")");
        }
        return;
    }
}