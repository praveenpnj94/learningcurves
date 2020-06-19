//https://www.interviewbit.com/problems/word-ladder-i/
//https://www.youtube.com/watch?v=M9cVl4d0v04
//https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/

// Java code to find the minimum number of Fibonacci terms 
// that sum to k. 
import java.util.*;
import java.util.LinkedList;

class GFG
{
    public static int solve(String A, String B, ArrayList<String> C) {
        if(A.equals(B)){
            return 0;
        }
        HashSet<String> hs = new HashSet<>();
        for(String s:C){
            hs.add(s);
        }
        Queue<String> q = new LinkedList<>();
        q.add(A);
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                char[] currArr = curr.toCharArray();
                for(int j=0;j<currArr.length;j++){
                    char original = currArr[j];
                    for(char c = 'a';c<='z';c++){
                        if(currArr[j]==c) continue;
                        currArr[j]=c;
                        String s = new String(currArr);
                        if(s.equals(B)){
                            return level+1;
                        }
                        if(C.contains(new String(currArr))){
                            q.add(s);
                            hs.remove(s);
                        }
                    }
                    currArr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main (String[] args) {

        String[] arr = {"hot", "dot", "dog", "lot", "log"};
        ArrayList<String> al = new ArrayList<String>(Arrays.asList(arr));
        System.out.println(solve("hit","cog", al));
    }
}

/* This code is contributed by Akash Singh*/

