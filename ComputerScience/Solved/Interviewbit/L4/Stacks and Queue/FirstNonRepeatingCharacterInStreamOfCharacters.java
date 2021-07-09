//https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/#

public class Solution {
    public String solve(String str) {
        
        // count array of size 26(assuming 
        // only lower case characters are present) 
        int[] charCount = new int[26]; 
  
        // Queue to store Characters 
        Queue<Character> q = new LinkedList<Character>(); 
        StringBuilder sb = new StringBuilder();
        // traverse whole stream 
        for (int i = 0; i < str.length(); i++) { 
            char ch = str.charAt(i); 
  
            // push each character in queue 
            q.add(ch); 
  
            // increment the frequency count 
            charCount[ch - 'a']++; 
            
            // check for the non repeating character 
            while (!q.isEmpty()) { 
                if (charCount[q.peek() - 'a'] > 1) 
                    q.remove(); 
                else { 
                    sb.append(q.peek()); 
                    break; 
                } 
            } 
            if (q.isEmpty()) 
                sb.append("#"); 
        } 
        return sb.toString();
    }
    
}
