//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//https://www.youtube.com/watch?v=21OuwqIC56E&ab_channel=KevinNaughtonJr.

class Solution {
    Map<Character,String> map;
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return list;
        }
        initialize();
        helper(digits,list,"",0);
        return list;
    }
    
    public void helper(String digits, List<String> list, String res, int index){
        if(index==digits.length()){
            list.add(res);
            return;
        }
        String s = map.get(digits.charAt(index));
        for(int i = 0;i<s.length();i++){
            helper(digits,list,res+s.charAt(i),index+1);
        }
    }
    
    public void initialize(){
        map=new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
}