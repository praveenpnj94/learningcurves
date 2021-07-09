//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/max-non-overlapping-bridges-official/ojquestion#

//https://www.geeksforgeeks.org/dynamic-programming-building-bridges/

//https://www.youtube.com/watch?list=TLGGgByTZQF3j1oxOTAxMjAyMQ&v=o1h3aoeSTOU&feature=youtu.be&ab_channel=Pepcoding

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
                /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Bridge[] bridges = new Bridge[t];
        for(int i=0;i<t;i++){
            String st = br.readLine();
            String[] s = st.split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            bridges[i]= new Bridge(a,b);
        }
        
        Arrays.sort(bridges, new BridgeComparator());
        
        int[] dp = new int[t];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<t;i++){
            for(int j=0;j<i;j++){
                if(bridges[i].s>=bridges[j].s){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}


class Bridge{
    int n;
    int s;
    
    Bridge(int n, int s){
        this.n=n;
        this.s=s;
    }
}

class BridgeComparator implements Comparator<Bridge>{
    
    public int compare(Bridge b1, Bridge b2){
        if(b1.n!=b2.n){
            return b1.n-b2.n;
        }
        else{
            return b1.s-b2.s;
        }
    }
}