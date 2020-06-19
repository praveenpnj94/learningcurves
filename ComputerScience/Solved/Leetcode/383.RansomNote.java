//https://leetcode.com/problems/ransom-note/
//https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> mag = new HashMap<>();
        for(int i =0;i<magazine.length();i++){
            Character c = magazine.charAt(i);
            mag.put(c,mag.getOrDefault(c,0)+1);
        }
        for(int j=0;j<ransomNote.length();j++){
            char c = ransomNote.charAt(j);
            if(!mag.containsKey(c)){
                return false;
            }
            else{
                int cnt = mag.get(c);
                if(cnt<=0){
                    return false;
                }
                cnt--;
                mag.put(c,cnt);
            }
        }
        return true;
    }
}