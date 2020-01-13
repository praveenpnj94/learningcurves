//https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/


class match
{
    // Fills lps[] for given patttern pat[0..M-1] 
    void computeLPSArray(String pat, int M, int lps[]) 
    { 
        char[] pattern = pat.toCharArray();
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
	
    }
    
    boolean KMPSearch(String pat, String txt)
    {
        char[] pattern = pat.toCharArray();
        char[] text = txt.toCharArray();
        int s = pattern.length;
        int[] lps = new int[s];
        computeLPSArray(pat,pattern.length,lps);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
}
