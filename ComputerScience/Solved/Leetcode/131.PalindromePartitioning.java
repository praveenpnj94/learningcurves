//https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s==null||s.length()==0){
            return result;
        }
        helper(s,result,new ArrayList<>(),0);
        return result;
    }
    
    public void helper(String s, List<List<String>> result, List<String> item, int start){
        if(start==s.length()){
            result.add(new ArrayList<>(item));
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                item.add(s.substring(start,i+1));
                helper(s,result,item,i+1);
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