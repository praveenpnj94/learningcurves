//https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/

/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class GfG
{
    static Node root;
    public static Node createTree(int arr[], int n)
    {
        Node[] created = new Node[n]; 
        for (int i = 0; i < n; i++)  
            created[i] = null; 
   
        for (int i = 0; i < n; i++) 
            createNode(arr, i, created); 
   
        return root;
    }
    
    // Creates a node with key as 'i'.  If i is root, then it changes 
    // root.  If parent of i is not created, then it creates parent first 
    public static void createNode(int parent[], int i, Node created[])  
    { 
        // If this node is already created 
        if (created[i] != null) 
            return; 
   
        // Create a new node and set created[i] 
        created[i] = new Node(i); 
   
        // If 'i' is root, change root pointer and return 
        if (parent[i] == -1)  
        { 
            root = created[i]; 
            return; 
        } 
   
        // If parent is not created, then create parent first 
        if (created[parent[i]] == null) 
            createNode(parent, parent[i], created); 
   
        // Find parent pointer 
        Node p = created[parent[i]]; 
   
        // If this is first child of parent 
        if (p.left == null) 
            p.left = created[i]; 
        else // If second child 
           
            p.right = created[i]; 
    }
    
}
