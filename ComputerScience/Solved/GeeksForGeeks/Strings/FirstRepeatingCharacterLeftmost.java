//https://www.geeksforgeeks.org/repeated-character-whose-first-appearance-is-leftmost/

import java.util.*; 

class Repeatation
{
    static int repeatedCharacter(String S)
    {
        char[] aArray = S.toCharArray();
        LinkedHashMap<Character,Integer> firstMap = new LinkedHashMap<Character,Integer>();
        for(int i=0;i<aArray.length;i++){
            if(firstMap.containsKey(aArray[i])){
                int cnt = firstMap.get(aArray[i]);
                firstMap.put(aArray[i],cnt+1);
            }
            else{
                firstMap.put(aArray[i],1);
            }
        }
        for(Map.Entry<Character,Integer> entry:firstMap.entrySet()){
            if(entry.getValue()>1){
                return findIndex(aArray,entry.getKey());
            }
        }
        return -1;
    }
    static int findIndex(char[] arr,char c){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==c){
                return i;
            }
        }
        return -1;
    }

    static int NO_OF_CHARS= 256; 
  
/* The function returns index of the first  
repeating character in a string. If  
all characters are repeating then  
returns -1 */
static int firstRepeating(String str) 
{ 
    // Mark all characters as not visited 
    boolean []visited = new boolean[NO_OF_CHARS]; 
    for (int i = 0; i < NO_OF_CHARS; i++) 
        visited[i] = false; 
  
    // Traverse from right and update res as soon 
    // as we see a visited character. 
    int res = -1; 
    for (int i = str.length() - 1; i >= 0; i--)  
    { 
        if (visited[str.charAt(i)] == false) 
            visited[str.charAt(i)] = true; 
        else
            res = i; 
    } 
  
    return res; 
} 
}