//https://www.interviewbit.com/problems/n3-repeat-number/
//https://www.geeksforgeeks.org/n3-repeated-number-array-o1-space/


public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        HashMap<Integer,Integer> m =new HashMap<Integer,Integer>();
        for(int i=0;i<a.size();i++){
            if(!m.containsKey(a.get(i))){
                m.put(a.get(i),1);
            }
            else{
                int count=m.get(a.get(i));
                m.put(a.get(i),count+1);
            }
        }
        int c= a.size()/3;
        for (Map.Entry<Integer,Integer> entry : m.entrySet()) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        if(value>c){
            return key;
        }
        }
        return -1;
    }
}

/*


// Java program to find if any element appears
// more than n/3.
class GFG {
     
    static int appearsNBy3(int arr[], int n)
    {
        int count1 = 0, count2 = 0;
         
        // take the integers as the maximum 
        // value of integer hoping the integer
        // would not be present in the array
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
     
        for (int i = 1; i < n; i++) {
     
            // if this element is previously
            // seen, increment count1.
            if (first == arr[i])
                count1++;
     
            // if this element is previously
            // seen, increment count2.
            else if (second == arr[i])
                count2++;
         
            else if (count1 == 0) {
                count1++;
                first = arr[i];
            }
     
            else if (count2 == 0) {
                count2++;
                second = arr[i];
            }
     
            // if current element is different
            // from both the previously seen
            // variables, decrement both the
            // counts.
            else {
                count1--;
                count2--;
            }
        }
     
        count1 = 0;
        count2 = 0;
     
        // Again traverse the array and 
        // find the actual counts.
        for (int i = 0; i < n; i++) {
            if (arr[i] == first)
                count1++;
     
            else if (arr[i] == second)
                count2++;
        }
     
        if (count1 > n / 3)
            return first;
     
        if (count2 > n / 3)
            return second;
     
        return -1;
    }
     
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 1, 1 };
        int n = arr.length;
        System.out.println(appearsNBy3(arr, n));
         
    }
}
*/