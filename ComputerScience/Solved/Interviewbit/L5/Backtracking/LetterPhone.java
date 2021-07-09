//https://www.interviewbit.com/problems/letter-phone/

public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        if(A==null||A.length()==0){
            return new ArrayList<String>();
        }
        String[] mapping={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> result = new ArrayList<>();
        helper(result,"",mapping,A,0);
        return result;
    }
    
    public void helper(ArrayList<String> result,String curr,String[] mapping,String A,int index){
        if(index>=A.length()){
            result.add(curr);
            return;
        }
        int id = (int)(A.charAt(index)-'0');
        String s = mapping[id];
        for(int i=0;i<s.length();i++){
            helper(result,curr+s.charAt(i),mapping,A,index+1);
        }
    }
}
