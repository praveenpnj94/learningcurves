//https://www.geeksforgeeks.org/counting-sort/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountingSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            long n = sc.nextLong();
            char seq[] = new char[(int)n+1];
            String str = "";
            str = sc.next();
            seq = str.toCharArray();
            countSort(seq);
            System.out.println(seq);
        }
    }

    public static void countSort(char seq[])
    {
        int size = seq.length;
        int[] sequence = new int[size];
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<seq.length;i++){
            int value = (int)seq[i];
            sequence[i]=value;
            max=Math.max(max,value);
            min=Math.min(min,value);
            if(map.containsKey(seq[i])){
                map.put(seq[i],map.get(seq[i])+1);
            }
            else{
                map.put(seq[i],1);
            }
        }
        int[] range = new int[max-min+1];
        int[] count = new int[max-min+1];
        int[] countSum = new int[max-min+1];
        int[] modCountSum = new int[max-min+1];
        int[] res = new int[size];
        int initial = min;
        int prev = initial;
        int curr =0;
        for(int i =0;i<max-min+1;i++){
            range[i]=initial;
            count[i]=map.get((char)initial)!=null?map.get((char)initial):0;
            if(i==0){
                countSum[i]= count[i];
                curr= countSum[i];
            }
            else{
                curr+=count[i];
                countSum[i]=curr;
            }
            initial++;
        }
        for(int j=1;j<max-min+1;j++){
            modCountSum[j]=countSum[j-1];
        }
        for(int k=0;k<size;k++){
            int position = modCountSum[sequence[k]-min];
            res[position] = sequence[k];
            modCountSum[sequence[k]-min]=modCountSum[sequence[k]-min]+1;
        }
        for(int l=0;l<res.length;l++){
            seq[l]=(char)res[l];
        }
    }
}

