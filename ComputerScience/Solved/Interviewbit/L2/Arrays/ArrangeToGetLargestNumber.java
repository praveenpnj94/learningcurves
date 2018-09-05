//https://www.interviewbit.com/problems/largest-number/
//https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        int zerocnt=0;
        Vector<String> arr;
        arr = new Vector<>();
        for(int i=0;i<A.size();i++){
            if(A.get(i)==0){
                zerocnt++;
            }
            arr.add(A.get(i).toString());
        }
        if(zerocnt==A.size()){
            return "0";
        }
        return printLargest(arr);
    }
    
    public String printLargest(Vector<String> arr){
     
        Collections.sort(arr, new Comparator<String>(){
 
        // A comparison function which is used by 
        // sort() in printLargest()
        @Override
        public int compare(String X, String Y) {
         
        // first append Y at the end of X
        String XY=X + Y;
         
        // then append X at the end of Y
        String YX=Y + X;
         
        // Now see which of the two formed numbers 
        // is greater
        return XY.compareTo(YX) > 0 ? -1:1;
    }
    });
         
    Iterator it = arr.iterator();
    StringBuffer str = new StringBuffer ("");
    while(it.hasNext()){
         str.append(it.next());       
    }
    return str.toString();
}
}
