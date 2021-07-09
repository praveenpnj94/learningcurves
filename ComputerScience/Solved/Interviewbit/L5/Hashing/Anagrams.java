//https://www.interviewbit.com/problems/anagrams/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A==null||A.size()==0){
            return res;
        }
        LinkedHashMap<String,ArrayList<Integer>> map = new LinkedHashMap<>();
        for(int i=0;i<A.size();i++){
            String s = A.get(i);
            char[] sa = s.toCharArray();
            Arrays.sort(sa);
            s = new String(sa);
            if(map.containsKey(s)){
                ArrayList<Integer> al = map.get(s);
                al.add(i+1);
                map.put(s,al);
            }
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i+1);
                map.put(s,al);
            }
        }
        for(String a:map.keySet()){
            ArrayList<Integer> al = map.get(a);
            res.add(al);
        }
        return res;
    }
}
