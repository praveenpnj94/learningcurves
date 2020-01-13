//https://www.geeksforgeeks.org/the-celebrity-problem/


class Celebrity
{
    // The task is to complete this function
    int getId2(int M[][], int n)
    {
        // Initialize two pointers  
        // as two corners 
        int a = 0; 
        int b = n - 1; 
          
        // Keep moving while  
        // the two pointers 
        // don't become same. 
        while (a < b)  
        { 
            if (knows(a, b,M)) 
                a++; 
            else
                b--; 
        } 
  
        // Check if a is actually  
        // a celebrity or not 
        for (int i = 0; i < n; i++)  
        { 
            // If any person doesn't  
            // know 'a' or 'a' doesn't 
            // know any person, return -1 
            if (i != a && (knows(a, i,M) ||  
                           !knows(i, a,M))) 
                return -1; 
        } 
        return a;
    }
    static boolean knows(int a, int b,int M[][])  
    { 
        boolean res = (M[a][b] == 1) ?  
                                     true :  
                                     false; 
        return res; 
    } 
    
    static int getId(int M[][], int n)
    { 
        Stack<Integer> st = new Stack<>(); 
        int c; 
  
        // Step 1 :Push everybody 
        // onto stack 
        for (int i = 0; i < n; i++)  
        { 
            st.push(i); 
        } 
  
        while (st.size() > 1)  
        { 
            // Step 2 :Pop off top 
            // two persons from the  
            // stack, discard one  
            // person based on return 
            // status of knows(A, B). 
            int a = st.pop(); 
            int b = st.pop(); 
  
            // Step 3 : Push the  
            // remained person onto stack. 
            if (knows(a, b,M))  
            { 
                st.push(b); 
            } 
  
            else
                st.push(a); 
        } 
  
        c = st.pop(); 
  
        // Step 5 : Check if the last  
        // person is celebrity or not 
        for (int i = 0; i < n; i++)  
        { 
            // If any person doesn't 
            //  know 'c' or 'a' doesn't  
            // know any person, return -1 
            if (i != c && (knows(c, i,M) ||  
                          !knows(i, c,M))) 
                return -1; 
        } 
        return c; 
    }
}
