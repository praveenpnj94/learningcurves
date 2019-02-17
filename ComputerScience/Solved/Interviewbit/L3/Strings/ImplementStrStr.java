//https://www.interviewbit.com/problems/implement-strstr/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B)
    {
        if(A.length() == 0 || B.length() ==0)
            return -1;
        else if(A.length()<B.length())
            return -1;
        else
        {
            int n = A.length();
            int m = B.length();
            int flag = 0;
            for(int i = 0 ;i <=n-m;i++)
            {
                String s = A.substring(i,i+m);
                //System.out.println(s);
                if(s.equals(B))
                {
                    return i;
                }
            }
            return -1;
        }
    }
}