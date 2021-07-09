//https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
	    for(int i=0;i<tokens.length;i++){
	        if(isDigit(tokens[i])){
	            st.push(Integer.parseInt(tokens[i]));
	        }
	        else{
	            int o2 = st.pop();
	            int o1 = st.pop();
	            st.push(getResult(o1,o2,tokens[i]));
	        }
	    }
	    return st.peek();
    }
    
    public int getResult(int o1,int o2,String c){
	    if(c.equals("/")){
	        return o1/o2;
	    }
	   	    if(c.equals("*")){
	        return o1*o2;
	    }
	    	    if(c.equals("-")){
	        return o1-o2;
	    }
	    	    if(c.equals("+")){
	        return o1+o2;
	    }
	    return 0;
	}
    
    public boolean isDigit(String s){
        if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")){
            return false;
        }
        return true;
    }
}