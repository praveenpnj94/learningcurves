//https://www.interviewbit.com/problems/equal/

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
       Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<A.size()-1;i++){
            for(int j=i+1;j<A.size();j++){
                int sum=A.get(i)+A.get(j);
                if(map.containsKey(sum)){
                    int f=map.get(sum).get(0);
                    int s=map.get(sum).get(1);
                    if(f==i||f==j||s==i||s==j) continue;
                    map.get(sum).addAll(Arrays.asList(i,j));
                }
                else map.put(sum,new ArrayList<>(Arrays.asList(i,j)));
            }
        }
         for(int i=0;i<A.size()-1;i++){
            for(int j=i+1;j<A.size();j++){
                int sum=A.get(i)+A.get(j);
                if(map.get(sum).size()>2){
                    result.addAll(Arrays.asList(i,j,map.get(sum).get(2),map.get(sum).get(3)));
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }
}
