//https://leetcode.com/problems/reorganize-string/
//https://www.youtube.com/watch?v=zaM_GLLvysw&ab_channel=KevinNaughtonJr.

class Solution {
    public String reorganizeString(String S) {
        if(S==null||S.length()==0){
            return S;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c :S.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){
            char first = pq.poll();
            char second = pq.poll();
            
            sb.append(Character.toString(first));
            sb.append(Character.toString(second));
            
            map.put(first,map.get(first)-1);
            map.put(second,map.get(second)-1);
            
            if(map.get(first)>0){
                pq.add(first);
            }
            
            if(map.get(second)>0){
                pq.add(second);
            }
        }
        
        if(pq.size()==1){
            char c = pq.poll();
            if(map.get(c)>1){
                return "";
            }
            sb.append(Character.toString(c));
        }
        
        return sb.toString();
    }
}