//https://www.interviewbit.com/problems/window-string/

public class Solution {
    public String minWindow(String s, String t) {
            // HashMap<Character,Integer> tMap = new HashMap<>();
            // char[] tarr = t.toCharArray();
            // for(Character c:tarr){
            //     tMap.put(c,tMap.getOrDefault(c,0).intValue()+1);
            // }
            // HashMap<Character,Integer> sMap = new HashMap<>();
            // int mcnt=0;
            // int dmcnt = t.length();
            // String ans="";
            // int i=-1;
            // int j=-1;
            // while(true){
            //     boolean a=false;
            //     boolean b=false;
            //     while(i<s.length()-1 && mcnt<dmcnt){
            //         i++;
            //         char c = s.charAt(i);
            //         sMap.put(c,sMap.getOrDefault(c,0).intValue()+1);
                    
            //         if(sMap.getOrDefault(c,0).intValue()<=tMap.getOrDefault(c,0).intValue()){
            //             mcnt++;
            //         }
            //         a=true;
            //     }
                
            //     while(j<i && mcnt==dmcnt){
            //         String pans = s.substring(j+1,i+1);
            //         if(ans.length()==0||pans.length()<ans.length()){
            //             ans=pans;
            //         }
                    
            //         j++;
            //         char c = s.charAt(j);
            //         if(sMap.get(c).intValue()==1){
            //             sMap.remove(c);
            //         }
            //         else{
            //             sMap.put(c,sMap.get(c).intValue()-1);
            //         }
                    
            //         if(sMap.getOrDefault(c,0).intValue()<tMap.getOrDefault(c,0).intValue()){
            //             mcnt--;
            //         }
            //         b=true;
            //     }
            //     if(!a&&!b){
            //         break;
            //     }
            // }
            // return ans;
            
            if(s == null || s.length() < t.length() || s.length() == 0){
        return "";
    }
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    for(char c : t.toCharArray()){
        if(map.containsKey(c)){
            map.put(c,map.get(c)+1);
        }else{
            map.put(c,1);
        }
    }
    int left = 0;
    int minLeft = 0;
    int minLen = s.length()+1;
    int count = 0;
    for(int right = 0; right < s.length(); right++){
        if(map.containsKey(s.charAt(right))){
            map.put(s.charAt(right),map.get(s.charAt(right))-1);
            if(map.get(s.charAt(right)) >= 0){
                count ++;
            }
            while(count == t.length()){
                if(right-left+1 < minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) > 0){
                        count --;
                    }
                }
                left ++ ;
            }
        }
    }
    if(minLen>s.length())  
    {  
        return "";  
    }  
    
    return s.substring(minLeft,minLeft+minLen);
    }
}
