//https://leetcode.com/problems/reverse-words-in-a-string/
//https://www.youtube.com/watch?v=jk0xszeMP9U&ab_channel=ProgrammingTutorials


class Solution {
    // public String reverseWords(String s) {
    //     if(s==null||s.length()==0){
    //         return s;
    //     }
    //     s=s.trim();
    //     List<String> wordList = Arrays.asList(s.split("\\s+"));
    //     Collections.reverse(wordList);
    //     return String.join(" ", wordList);
    // }
    
    public String reverseWords(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            int start = i;
            while(i<s.length() && s.charAt(i)!=' '){
                sb.append(s.charAt(i++));
            }
            st.push(sb.toString());
            sb = new StringBuilder();
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(st.size()>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

//Java Code
public class ReverseWords {
    public static String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    //Traverse a string
    for (int i = 0; i < s.length(); i++) {
    //If it is space then continue
    if(s.charAt(i) == ' ') continue;
    //Initialize with start pointer
    int start = i;
    //Run this loop until space is encountered
    while(i < s.length() && s.charAt(i) != ' ') i++;
    //If stringbuilder is empty, Add the first word at 0th offset
    if(result.length() == 0)
    result.insert(0, s.substring(start, i));
    else
    result.insert(0, " ").insert(0, s.substring(start, i));
    }
    return result.toString();
    }
    public static void main(String[] args) {
    String str = " Three is word ";
    System.out.println(reverseWordsAppr(str));
    }
}
    