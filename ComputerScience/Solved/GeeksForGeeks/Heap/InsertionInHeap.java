

// Java program for implement insertion in Heaps
public class insertionHeap {
    private int[] arr; 
    private int size; 
    private int maxsize; 
  
    // Constructor to initialize an 
    // empty max heap with maximum capacity. 
    public insertionHeap() 
    { 
        this.maxsize = 1000; 
        this.size = -1; 
        arr = new int[this.maxsize + 1]; 
        
    } 
    
    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    
    private void heapify(int i)
    {   
        int n=size+1 ;

        // Find parent
    int parent = (i - 1) / 2;

    if (parent >= 0) {

        // For Max-Heap
        // If current node is greater than its parent
        // Swap both of them and call heapify again
        // for the parent
        if (arr[i] > arr[parent]) {
            int temp=arr[parent];
            arr[parent]=arr[i];
            arr[i]=temp;
            // swap
            // Recursively heapify the parent node
            heapify(parent);
        }
    }
    }

    // Function to insert key to heap
    // Inserts a new element to max heap 
    public void insert(int element) 
    { 
        arr[++size] = element; 
        if(size>0)
            heapify(size);
    } 

    /* A utility function to print array of size N */
    public void printArray()
    {
        for (int i = 0; i <= size; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver Code
    public static void main(String args[])
    {
        // Array representation of Max-Heap
        //     10
        //    /  \
        //   5    3
        //  / \
        // 2   4
        insertionHeap h = new insertionHeap();
        h.insert(10);
        h.insert(5);
        h.insert(3);
        h.insert(2);
        h.insert(4);
        h.insert(15);
      
        
        h.printArray();
    }
}
