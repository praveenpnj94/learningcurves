//https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String a = br.readLine();
            String b = br.readLine();
            System.out.println(checkIfIsomorphic(a,b));
        }
    }
    public static int checkIfIsomorphic(String a, String b){
        if(a.length()!=b.length()){
            return 0;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        LinkedHashMap<Character,Integer> firstMap = new LinkedHashMap<Character,Integer>();
        LinkedHashMap<Character,Integer> secondMap = new LinkedHashMap<Character,Integer>();
        for(int i=0;i<aArray.length;i++){
            if(firstMap.containsKey(aArray[i])){
                int cnt = firstMap.get(aArray[i]);
                firstMap.put(aArray[i],cnt+1);
            }
            else{
                firstMap.put(aArray[i],1);
            }
            if(secondMap.containsKey(bArray[i])){
                int cnt = secondMap.get(bArray[i]);
                secondMap.put(bArray[i],cnt+1);
            }
            else{
                secondMap.put(bArray[i],1);
            }
        }
        if(firstMap.keySet().size()!=secondMap.keySet().size()){
            return 0;
        }
        else{
            int size = firstMap.keySet().size();
            List<Character> firstSet = new ArrayList<>(firstMap.keySet());
            List<Character> secondSet = new ArrayList<>(secondMap.keySet());
            for(int j=0;j<size;j++){
                char fkey = firstSet.get(j);
                char skey = secondSet.get(j);
                int fval = firstMap.get(fkey);
                int sval = secondMap.get(skey);
                if(fval!=sval){
                    return 0;
                }
            }
        }
        return 1;
    }
}