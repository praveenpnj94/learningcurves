//https://leetcode.com/problems/merge-intervals/
//https://www.youtube.com/watch?v=QlaDyZTCAbM&ab_channel=Pepcoding
//https://www.youtube.com/watch?v=RGr2RuH6iH4&ab_channel=CodeLibrary

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length<=1||intervals[0].length==0){
            return intervals;
        }
        Pair[] pair = new Pair[intervals.length];
        int idx=0;
        for(int[] p:intervals){
            pair[idx++]=new Pair(p[0],p[1]);
        }
        Arrays.sort(pair,new IntervalComparator());
        
        int i=0;
        int j=1;
        while(j<intervals.length){
            if(pair[j].s<=pair[i].e){
                pair[i].e=Math.max(pair[i].e,pair[j].e);
            }
            else{
                i++;
                pair[i]=pair[j];
            }
            j++;
        }
        int[][] res= new int[i+1][2];
        int cnt=0;
        for(Pair p:pair){
            if(cnt>i){
                break;
            }
            res[cnt][0]=p.s;
            res[cnt][1]=p.e;
            cnt++;
        }
        return res;
    }
    
    // public int[][] merge(int[][] intervals) {
    //     if(intervals==null||intervals.length<=1||intervals[0].length==0){
    //         return intervals;
    //     }
    //     Pair[] pair = new Pair[intervals.length];
    //     int idx=0;
    //     for(int[] p:intervals){
    //         pair[idx++]=new Pair(p[0],p[1]);
    //     }
    //     Arrays.sort(pair,new IntervalComparator());
    //     Stack<Pair> st = new Stack<>();
    //     int i=0;
    //     for(Pair p:pair){
    //         if(i==0){
    //             st.push(p);
    //         }
    //         if(p.s<=st.peek().e){
    //             Pair top = st.pop();
    //             top.e=Math.max(top.e,p.e);
    //             st.push(top);
    //         }
    //         else{
    //             st.push(p);
    //         }
    //         i++;
    //     }
    //     int[][] res= new int[st.size()][2];
    //     int cnt=st.size()-1;
    //     while(!st.isEmpty()){
    //         Pair temp = st.pop();
    //         res[cnt][0]=temp.s;
    //         res[cnt][1]=temp.e;
    //         cnt--;
    //     }
    //     return res;
    // }
}
class Pair{
    int s;
    int e;
    Pair(int s, int e){
        this.s=s;
        this.e=e;
    }
}
class IntervalComparator implements Comparator<Pair>{
    
    public int compare(Pair p,Pair q){
        if(p.s!=q.s){
            return p.s-q.s;
        }
        else{
            return p.e-q.e;
        }
    }
}