//https://leetcode.com/discuss/interview-experience/821453/goldman-sach-virtual-interview

public class Solution{
    public String burst(String str, int burst) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length();) {
            int j = i+1;
            while(j < str.length() && str.charAt(i) == str.charAt(j)) j++;
            sb.append(j-i >= burst ? "" : str.substring(i, j));
            i = j;
        }
        return sb.toString();
    }
}