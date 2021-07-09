//https://www.interviewbit.com/problems/subarray-with-equal-occurences/



public class Solution {
    public int solve(int[] arr, int x, int y) {
    int n = arr.length;
            int []countX = new int[n]; 
    int []countY = new int[n]; 
  
    Map<Integer,Integer> m = new HashMap<>();  
      
    // To store counts of same diff 
    // Count occurrences of x and y 
    for (int i = 0; i < n; i++) 
    { 
        if (arr[i] == x)  
        { 
            if (i != 0) 
                countX[i] = countX[i - 1] + 1; 
            else
                countX[i] = 1; 
        }  
        else
        { 
            if (i != 0) 
                countX[i] = countX[i - 1]; 
            else
                countX[i] = 0; 
        } 
        if (arr[i] == y) 
        { 
            if (i != 0) 
                countY[i] = countY[i - 1] + 1; 
            else
                countY[i] = 1; 
        }  
        else 
        { 
            if (i != 0) 
                countY[i] = countY[i - 1]; 
            else
                countY[i] = 0; 
        } 
      
        // Increment count of current 
        if(m.containsKey(countX[i] - countY[i])) 
        { 
            m.put(countX[i] - countY[i], m.get(countX[i] - countY[i])+1); 
        } 
        else
        { 
            m.put(countX[i] - countY[i], 1); 
        } 
    } 
  
    // Traverse map and commute result.  
    int result = m.get(0); 
    for (Map.Entry<Integer,Integer> it : m.entrySet())  
        result = result + ((it.getValue()) * ((it.getValue()) - 1)) / 2; 
      
    return (result);
    }
}


public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        int occur_B = 0;
        int occur_C = 0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<A.size();i++){
            if(A.get(i)==B){
                occur_B++;
            }
            else if(A.get(i)==C){
                occur_C++;
            }
            if(map.containsKey(occur_B-occur_C)){
                count=count+map.get(occur_B-occur_C);
            }
            Integer a=map.getOrDefault(occur_B-occur_C,0);
            a++;
            map.put(occur_B-occur_C,a);
            
        }
        return count;
        
    }
}
