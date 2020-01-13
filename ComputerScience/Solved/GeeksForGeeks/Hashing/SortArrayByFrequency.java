

class Sorting
{
    static void sortByFreq(int a[], int n)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(map.containsKey(a[i])){
                int cnt = map.get(a[i]);
                map.put(a[i],cnt+1);
            }
            else{
                map.put(a[i],1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            list.add(a[j]);
        }
        Collections.sort(list, new SortComparator(map));
        for(int k=0;k<n;k++){
            System.out.print(list.get(k)+" ");
        }
    }
}
class SortComparator implements Comparator<Integer>{
    
    HashMap<Integer,Integer> map;
    
    public SortComparator(HashMap<Integer,Integer> map){
        this.map = map;
    }
    
    @Override
    public int compare(Integer a, Integer b){
        int frequencyCompare = map.get(b).compareTo(map.get(a));
        int valueCompare = a.compareTo(b);
        if(frequencyCompare==0){
            return valueCompare;
        }
        else{
            return frequencyCompare;
        }
    }
}