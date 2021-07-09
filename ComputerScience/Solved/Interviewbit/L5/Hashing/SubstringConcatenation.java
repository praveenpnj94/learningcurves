//https://www.interviewbit.com/problems/substring-concatenation/
//https://www.youtube.com/watch?v=Mv5UNKdKwz4&ab_channel=PrakashShukla

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String s, final List<String> words) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(s.length()==0||words.size()==0){
            return ans;
        }
        HashMap<String,Integer> firstMap = new HashMap<>();
        for(String st:words){
            firstMap.put(st,firstMap.getOrDefault(st,0)+1);
        }
        int tl = words.size()*words.get(0).length();
        int sl = words.get(0).length();
        
        int i=0;
        while(i<=s.length()-tl){
            String sub = s.substring(i,i+tl);
            HashMap<String,Integer> secondMap = new HashMap<>();
            int k=0;
            int n=0;
            while(k<words.size()){
                String temp = sub.substring(n,n+sl);
                secondMap.put(temp,secondMap.getOrDefault(temp,0)+1);
                n+=sl;
                k++;
            }
            if(secondMap.equals(firstMap)){
                ans.add(i);
            }
            i++;
        }
        return ans;
    }
}
