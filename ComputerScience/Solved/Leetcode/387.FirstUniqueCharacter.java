//https://leetcode.com/problems/first-unique-character-in-a-string/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/

class Solution {
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        LinkedHashMap<Character,Integer> m = new LinkedHashMap<>();
        for(int i=0;i<c.length;i++){
            Character chars =  c[i];
            m.put(chars,m.getOrDefault(chars,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:m.entrySet()){
            if(entry.getValue()==1){
                return findIndex(c,entry.getKey());
            }
        }
        return -1;
    }
    public int findIndex(char[] c, char t){
        for(int i=0;i<c.length;i++){
            if(c[i]==t){
                return i;
            }
        }
        return -1;
    }
}