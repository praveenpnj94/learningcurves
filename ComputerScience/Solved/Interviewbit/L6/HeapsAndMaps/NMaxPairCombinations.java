//https://www.interviewbit.com/problems/n-max-pair-combinations/

public class Solution {
    public int[] solve(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int s1=a.length,s2=b.length,i=s1-1,j=s2-1,ind=0;
        int ans[]=new int[s1];
        PriorityQueue<node> pq=new PriorityQueue<node>(new Comparator<node>(){
            
                public  int compare(node n1,node n2){
                    return n2.sum - n1.sum;
                }
            });
            
            
        //ans[0]=a[i] + b[j];
        pq.add(new node(i,j,a[i] + b[j]));
        //System.out.println
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        while(ind<s1){
            
            node rem = pq.remove();
            
            i = rem.i ; j=rem.j;
            if(i-1>=0  &&  !map.containsKey((i-1)+" "+j)){
                pq.add(new node(i-1,j,a[i-1] + b[j]));
                map.put((i-1)+" "+j,1);
            }
            if(j-1>=0  &&  !map.containsKey(i+" "+(j-1))){
                pq.add(new node(i,j-1,a[i] + b[j-1]));
                 map.put(i+" "+(j-1),1);
            }
            
            
            ans[ind++]=rem.sum;
            
        }
        
        return ans;
    }
}


class node{
    int i,j,sum;
    public node(int i1,int j1,int s){
        i=i1;
        j=j1;
        sum=s;
    }
}
