//https://www.interviewbit.com/problems/palindrome-partitioning/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(a==null||a.length()==0){
            result.add(new ArrayList<String>());
            return result;
        }
        helper(result,a,new ArrayList<>(),0);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<String>> result,String s, List<String> item, int start){
        if(start==s.length()){
            result.add(new ArrayList<>(item));
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                item.add(s.substring(start,i+1));
                helper(result,s,item,i+1);
                item.remove(item.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low++)!=s.charAt(high--)){
                return false;
            }
        }
        return true;
    } 
}
