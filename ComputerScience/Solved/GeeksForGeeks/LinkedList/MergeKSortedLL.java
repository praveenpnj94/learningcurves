//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
// MIn heap method is misssing

class Merge
{
    Node mergeKList(Node[]arr,int N)
    {
        int last = N-1;
        // repeat until only one list is left  
        while (last != 0)  
        {  
            int i = 0, j = last;  
    
            // (i, j) forms a pair  
            while (i < j)  
            {  
                // merge List i with List j and store  
                // merged list in List i  
                arr[i] = merge(arr[i], arr[j]);  
    
                // consider next pair  
                i++; j--;  
    
                // If all pairs are merged, update last  
                if (i >= j)  
                    last = j;  
            }  
        }  
    
        return arr[0]; 
    }    
    
    Node mergeKList2(Node[]a,int N)
    {
        if(N==1){
            return a[0];
        }
        else if(N==2){
            return merge(a[0],a[1]);
        }
        else{
            Node s = merge(a[0],a[1]);
            for(int i=2;i<N;i++){
                s =  merge(s,a[i]);
            }
            return s;
        }
    }
    
    Node merge(Node a, Node b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<b.data){
           a.next =  merge(a.next,b);
           return a;
        }else{
           b.next = merge(a,b.next);
           return b;
        }
    }
}
