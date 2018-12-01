//https://www.interviewbit.com/problems/single-number/
//https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/

int findSingle(int ar[], int ar_size) 
    { 
        // Do XOR of all elements and return 
        int res = ar[0]; 
        for (int i = 1; i < ar_size; i++) 
            res = res ^ ar[i]; 
  
        return res; 
    }