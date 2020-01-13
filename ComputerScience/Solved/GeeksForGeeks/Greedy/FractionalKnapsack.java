//https://www.geeksforgeeks.org/fractional-knapsack-problem/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DecimalFormat;

class GFG {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] dim = br.readLine().trim().split(" ");
            int n = Integer.parseInt(dim[0]);
            int w = Integer.parseInt(dim[1]);
            String[] arr = br.readLine().trim().split(" ");
            List<Knapsack> sacks = new ArrayList<Knapsack>();
            List<Integer> values = new ArrayList<>();
            for(int i=0;i<arr.length;i=i+2){
                values.add(Integer.parseInt(arr[i]));
            }
            List<Integer> weights = new ArrayList<>();
            for(int i=1;i<arr.length;i=i+2){
                weights.add(Integer.parseInt(arr[i]));
            }
            for(int i=0;i<values.size();i++){
                int value = values.get(i);
                int weight = weights.get(i);
                double ratio = (double)value/weight;
                Knapsack k = new Knapsack(value,weight,ratio);
                sacks.add(k);
            }
            System.out.println(fractionalKnapSack(sacks,n,w));
        }
    }

    public static String fractionalKnapSack(List<Knapsack> sacklist, int n, int capacity){
        Collections.sort(sacklist,new KnapsackComparator());
        double totalProfit = 0;
        int totalWeight = 0;
        for(int i =0;i<n;i++){
            int curWt = sacklist.get(i).weight; 
            int curVal = sacklist.get(i).value; 
  
            if (capacity - curWt >= 0) 
            { 
                // this weight can be picked while 
                capacity = capacity-curWt; 
                totalProfit += curVal; 
  
            } 
            else
            { 
                // item cant be picked whole
                double fraction = ((double)capacity/(double)curWt);
                totalProfit += (curVal*fraction); 
                capacity = (int)(capacity - (curWt*fraction)); 
                break; 
            } 
        }
        return df.format(totalProfit);
    }
}
class Knapsack{
    int value;
    int weight;
    Double ratio;
    Knapsack(int value, int weight, double ratio){
        this.value = value;
        this.weight = weight;
        this.ratio = ratio;
    }
}
class KnapsackComparator implements Comparator<Knapsack> {

    @Override
    public int compare(Knapsack k1, Knapsack k2) {
        return k2.ratio.compareTo(k1.ratio);
    }
}